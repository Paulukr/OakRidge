package library.model.dao.implemantation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.model.dao.DaoConstants;
import library.model.dao.declaration.AuthorDao;
import library.model.entity.Author;
import library.model.exceptions.AuthorDublicateException;


public class AuthorDaoImpl extends AbstractDao implements AuthorDao {

	private static final Logger logger = Logger.getLogger(AbstractDao.class);
	protected AuthorDaoImpl(){}
    private static class LazyHolder {
        private static final AuthorDaoImpl INSTANCE = new AuthorDaoImpl();
    }
    public static AuthorDaoImpl getInstance(){
        return LazyHolder.INSTANCE;
    }

	@Override
	public Integer findAuthorID(String fullName) throws SQLException, AuthorDublicateException {
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(DaoConstants.AUTHOR_GET_NO);) {
			// (Author_name)
			preparedStatement.setString(1, fullName);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				if (resultSet.next()) {
					int result = resultSet.getInt(1);
					String duplicateList = null;
					while (resultSet.next()) {
						duplicateList += " " + result;
						result = resultSet.getInt(1);
					}
					if (duplicateList != null){
						AuthorDublicateException e = new AuthorDublicateException(ErrorList.DuplicateAuthors + duplicateList);
						logger.error(ErrorList.DuplicateAuthors + duplicateList, e);
						throw e;
					}

					return result;
				}
				return null;
			}
		} catch (SQLException e) {
			logger.error(ErrorList.SelectAuthor, e);
			throw new SQLException(ErrorList.SelectAuthor, e);
		}
	}

	@Override
	public Integer addAuthor(Author author) throws SQLException {
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DaoConstants.AUTHOR_ADD);) {
			// (Author_name)
			preparedStatement.setString(1, author.getName());
			try (ResultSet generatedKeys = preparedStatement.executeQuery()) {
				if (generatedKeys.next()) {
					return (generatedKeys.getInt(1));
				}
				SQLException e = new SQLException("Insert failed, no ID obtained.");
				logger.error(ErrorList.SelectAuthor, e);
				throw e;
			}
		} catch (SQLException e) {
			logger.error(ErrorList.SelectAuthor, e);
			throw new SQLException(ErrorList.SelectAuthor, e);
		}
	}

	public Author getAuthorByID(int databaseId) throws SQLException {
		Author author = new Author();
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DaoConstants.AUTHOR_GET_INSTANCE);) {
			preparedStatement.setInt(1, databaseId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					author.setFullName(resultSet.getString(1));
					return author;
				}
				return null;
			}
		} catch (SQLException e) {
			logger.error(ErrorList.SelectAuthor, e);
			throw new SQLException(ErrorList.SelectAuthor, e);
		}
	}
}
