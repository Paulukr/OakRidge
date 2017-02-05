package library.model.dao.implemantation;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.management.RuntimeErrorException;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import library.controller.ErrorList;
import library.model.dao.DatabaseUtility;

@SuppressWarnings("unused")
public abstract class AbstractDao {
	private static final Logger logger = Logger.getLogger(AbstractDao.class);
	protected AbstractDao() {
	}



	private static class LazyHolder {
		private static final ComboPooledDataSource DATA_SOURCE = initDataSource();

		private static ComboPooledDataSource initDataSource() {
			try {
				return DatabaseUtility.getDataSource();
			} catch (PropertyVetoException e) {
				logger.error(ErrorList.DataSourse, e);
				throw new RuntimeErrorException(new Error(e), ErrorList.DataSourse);
			}
		}
	}

	public static ComboPooledDataSource getdataSource() {
		return LazyHolder.DATA_SOURCE;
	}

	protected void init() throws SQLException {
		try {

			Connection connection = getdataSource().getConnection();
		} catch (SQLException e) {
			logger.error(ErrorList.DataSourse, e);
			throw new SQLException(ErrorList.DataSourse, e);
		}
	}

	public ResultSet doQuery(Function<Connection, PreparedStatement> queryBuilder) throws SQLException {
		try (Connection connection = getdataSource().getConnection()) {
			PreparedStatement preparedStatement = queryBuilder.apply(connection);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			logger.error(ErrorList.DataSourse, e);
			throw new SQLException(ErrorList.DataSourse, e);
		}
	}

	public void prepareStatement(String expression, Connection connection) throws SQLException {
		try {
			if (connection == null)
				init();
			PreparedStatement preparedStatement = connection.prepareStatement(expression);
		} catch (SQLException e) {
			logger.error(ErrorList.DataSourse, e);
			throw new SQLException(ErrorList.PreparingStatement, e);
		}
	}

	public void prepareStatementKeyGeneration(String expression, Connection connection) throws SQLException {
		try {
			if (connection == null)
				init();
			PreparedStatement preparedStatement = connection.prepareStatement(expression,
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			logger.error(ErrorList.DataSourse, e);
			throw new SQLException(ErrorList.PreparingStatement, e);
		}
	}
}
