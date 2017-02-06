package library.model.dao.implemantation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.model.dao.DaoConstants;
import library.model.entity.BookVolume;
import library.model.exceptions.BookDublicateException;

public class BookVolumeDaoImpl extends AbstractDao implements BookVolumeDao {

	private static final Logger logger = Logger.getLogger(BookVolumeDaoImpl.class);

	protected BookVolumeDaoImpl() {
	}

	private static class LazyHolder {
		private static final BookVolumeDao INSTANCE = new BookVolumeDaoImpl();
	}

	public static BookVolumeDao getInstance() {
		return LazyHolder.INSTANCE;
	}

	/*
	 * create table Volume_table (
Volume_no SERIAL not null primary key,
Vol_price real,
Vol_buy_year int,
Vol_available int,
Title_no int references Title_table(Title_no),
Borrow_type_available int
	 */


	/* (non-Javadoc)
	 * @see library.model.dao.implemantation.BookVolumeDao#getVolumePool(int)
	 */
	@Override
	public List<BookVolume> getVolumePool(int bookTitleId) throws SQLException {
		List<BookVolume> bookVolumes = new ArrayList<>();
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DaoConstants.BOOK_VOLUME_GET_PULL);) {

			preparedStatement.setInt(1, bookTitleId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					BookVolume bookVolume = new BookVolume();
					bookVolume.setPrice(resultSet.getDouble(1));
					bookVolume.setBuyYear(resultSet.getInt(2));
					bookVolume.setAvailable(resultSet.getInt(3));
					bookVolume.setTitle_no(resultSet.getInt(4));
					bookVolume.setBorrow_type_available(resultSet.getInt(5));
					bookVolumes.add(bookVolume);
				}
			}
		} catch (SQLException e) {
			logger.error(ErrorList.SELECT_VOLUME, e);
			throw new SQLException(ErrorList.SELECT_VOLUME, e);
		}
		return bookVolumes;
	}

	/* (non-Javadoc)
	 * @see library.model.dao.implemantation.BookVolumeDao#getAvaluableQuantity(int)
	 */
	@Override
	public int getAvaluableQuantity(int bookTitleId) throws SQLException {
		int result = 0;
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(DaoConstants.BOOK_VOLUME_GET_COUNT_AVAILABLE);) {
			preparedStatement.setInt(1, bookTitleId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next())
					result = resultSet.getInt(1);
				else
					throw new SQLException(ErrorList.ABSENT_RESULT_SET);
			}
		} catch (SQLException e) {
			logger.error(ErrorList.SELECT_VOLUME, e);
			throw new SQLException(ErrorList.SELECT_VOLUME, e);
		}
		return result;
	}

	public Integer straitLookUp(String title, int[] authorsList) throws SQLException, BookDublicateException {
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(DaoConstants.BOOK_TITLE_FIND_SIGNATURE);) {

			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, authorsList[0]);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					int result = resultSet.getInt(1);
					String duplicateList = null;
					while (resultSet.next()) {
						duplicateList += " " + result;
						result = resultSet.getInt(1);
					}
					if (duplicateList != null) {
						BookDublicateException e = new BookDublicateException(
								ErrorList.DUPLICATE_BOOKS + duplicateList);
						logger.error(ErrorList.DUPLICATE_BOOKS + duplicateList, e);
						throw e;
					}
					return result;
				}
				return null;
			}
		} catch (SQLException e) {
			logger.error(ErrorList.SELECT_BOOK, e);
			throw new SQLException(ErrorList.SELECT_AUTHOR, e);
		}
	}

	/*
	 * create table Volume_table Volume_no SERIAL not null primary key,
	 * Vol_price real, Vol_buy_year int, Vol_total_quantity int,
	 * Vol_available_quantity int, Title_no int references
	 * Title_table(Title_no), Borrow_type_available int
	 */

	/* (non-Javadoc)
	 * @see library.model.dao.implemantation.BookVolumeDao#getBookVolume(int)
	 */
	@Override
	public BookVolume getBookVolume(int databaseID) throws SQLException {
		BookVolume bookVolume = new BookVolume();
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(DaoConstants.BOOK_VOLUME_GET_INSTANCE);) {

			preparedStatement.setInt(1, databaseID);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				if (!resultSet.next())
					return null;
				bookVolume.setPrice(resultSet.getDouble(1));
				bookVolume.setBuyYear(resultSet.getInt(2));
				bookVolume.setAvailable(resultSet.getInt(3));
				bookVolume.setTitle_no(resultSet.getInt(4));
				bookVolume.setBorrow_type_available(resultSet.getInt(5));
			}
		} catch (SQLException e) {
			logger.error(ErrorList.SELECT_VOLUME, e);
			throw new SQLException(ErrorList.SELECT_VOLUME, e);
		}
		return bookVolume;
	}

	/* (non-Javadoc)
	 * @see library.model.dao.implemantation.BookVolumeDao#addBookVolume(library.model.entity.BookVolume)
	 */
	@Override
	public Integer addBookVolume(BookVolume volume) throws SQLException {

		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DaoConstants.BOOK_VOLUME_ADD);) {

			preparedStatement.setDouble(1, volume.getPrice());
			preparedStatement.setInt(2, volume.getBuyYear());
			preparedStatement.setInt(3, volume.getAvailable());
			preparedStatement.setInt(4, volume.getTitle_no());
			preparedStatement.setInt(5, volume.getBorrow_type_available());
			logger.debug("\n sql \n" + DaoConstants.BOOK_TITLE_ADD + " ");
			try (ResultSet generatedKeys = preparedStatement.executeQuery()) {
				if (generatedKeys.next()) {
					volume.setVolumeNo(generatedKeys.getInt(1));
				} else {
					throw new SQLException(ErrorList.INSERT_FAILED);
				}
			}
		} catch (SQLException e) {
			logger.error(ErrorList.INSERT_TITLE, e);
			throw new SQLException(ErrorList.INSERT_TITLE, e);
		}
		return volume.getVolumeNo();
	}
}