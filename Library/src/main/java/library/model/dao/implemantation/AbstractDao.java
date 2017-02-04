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

public abstract class AbstractDao  implements Closeable{
//	protected ComboPooledDataSource dataSource = null;
	protected static Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected int resultSetSize = 0;


    private static final Logger logger = Logger.getLogger(AbstractDao.class);

    private static class LazyHolder {
        private static final ComboPooledDataSource DATA_SOURCE = initDataSource();
    }
    public static ComboPooledDataSource getdataSource(){
        return LazyHolder.DATA_SOURCE;
    }
    private static ComboPooledDataSource initDataSource() {
		try {
			return DatabaseUtility.getDataSource();
		} catch (PropertyVetoException e) {
            logger.error(ErrorList.DataSourse, e);
            throw new RuntimeErrorException(new Error(e), ErrorList.DataSourse);
		}
	}
	protected void init() throws SQLException {
//TODO check close		ComboPooledDataSource dataSource;
		try {
//			dataSource = ;
			connection = getdataSource().getConnection();

		} catch (SQLException e) {
            logger.error(ErrorList.DataSourse, e);
            throw new SQLException(ErrorList.DataSourse, e);
		}
	}
	public ResultSet doQuery(Function<Connection,PreparedStatement> queryBuilder) throws SQLException {
		try(Connection connection = getdataSource().getConnection()){
			preparedStatement = queryBuilder.apply(connection);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
            logger.error(ErrorList.DataSourse, e);
            throw new SQLException(ErrorList.DataSourse, e);
		}
	}
	public void prepareStatement(String expression) throws SQLException {
		try {
			if(connection == null)
				init();
			preparedStatement = connection.prepareStatement(expression);
		} catch (SQLException e) {
            logger.error(ErrorList.DataSourse, e);
            throw new SQLException(ErrorList.PreparingStatement, e);
		}
	}
	public void prepareStatementKeyGeneration(String expression) throws SQLException {
		try {
			if(connection == null)
				init();
			preparedStatement = connection.prepareStatement(expression, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
            logger.error(ErrorList.DataSourse, e);
            throw new SQLException(ErrorList.PreparingStatement, e);
		}
	}
	public int query() throws SQLException
	{

		try

		{

			preparedStatement = connection.prepareStatement("SELECT * FROM title_table");

			System.out.println("\n\nHey YOU \n try");

			System.out.println("The Connection Object is of Class: " + connection.getClass());
			System.out.println("\n\nHey YOU \n class");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				resultSetSize++;
				System.out.println("\n\nHey YOU \n while");
				System.out.println("\n\nHey YOU \n" + resultSet.getString(1) + "," + resultSet.getString(2) + "," + resultSet.getString(3) + "\n");
			}

		}
		catch (Exception e)
		{
			System.out.println("\n\nHey YOU \n exception");
			connection.rollback();
			e.printStackTrace();
		}
		return resultSetSize;
	}
	@Override
	public void close() throws IOException {
		try {
			connection.close();
		} catch (SQLException e) {
            logger.error(ErrorList.DataSourse, e);
		}
	}

}
