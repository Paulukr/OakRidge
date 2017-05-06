package library.model.dao.implemantation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import library.controller.ErrorList;
import library.model.dao.DaoConstants;
import library.model.dao.declaration.BookTitleDao;
import library.model.dao.declaration.JItemDao;
import library.model.entity.Author;
import library.model.entity.BookTitle;
import library.model.entity.JItem;
import library.model.exceptions.BookDublicateException;


public class JItemDaoImpl extends AbstractDao implements JItemDao {

	private static final Logger logger = Logger.getLogger(JItemDaoImpl.class);
	protected JItemDaoImpl(){}
    private static class LazyHolder {
        private static final JItemDaoImpl INSTANCE = new JItemDaoImpl();
    }
    public static JItemDaoImpl getInstance(){
        return LazyHolder.INSTANCE;
    }
	@Override
	public JItem getJItemName(int databaseID) throws SQLException {
		JItem jitem = new JItem();
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DaoConstants.JITEM_GET_INSTANCE);) {

			preparedStatement.setInt(1, databaseID);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				if (!resultSet.next())
					return null;
				jitem.setName(resultSet.getString(1));
				jitem.setOrderNo(databaseID);

		} catch (SQLException e) {
			logger.error(ErrorList.INSERT_TITLE, e);
			throw new SQLException(ErrorList.INSERT_TITLE, e);
		}
		}
		return jitem;

	}
	@Override
	public int getJItemDispatch(int jItemNo, int quantity) throws SQLException {
		int result = 0;
		try (Connection connection = getdataSource().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DaoConstants.JITEM_GET_DISPATCH);) {

			preparedStatement.setInt(1, jItemNo);
			preparedStatement.setInt(2, quantity);

			try (ResultSet generatedKeys = preparedStatement.executeQuery()) {
				if (generatedKeys.next()) {
					result = generatedKeys.getInt(1);
				}
				else {
					throw new SQLException("Creating Dispatch failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			logger.error(ErrorList.INSERT_TITLE, e);
			throw new SQLException(ErrorList.INSERT_TITLE, e);
		}
		return result;
	}
}