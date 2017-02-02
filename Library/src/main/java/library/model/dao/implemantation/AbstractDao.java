package library.model.dao.implemantation;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import library.controller.ErrorList;
import library.dao.DatabaseUtility;

public abstract class AbstractDao {
	protected Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected int resultSetSize = 0;
	
    private static final Logger logger = Logger.getLogger(AbstractDao.class);
    

	protected void init() throws SQLException {
		ComboPooledDataSource dataSource;
		try {
			dataSource = DatabaseUtility.getDataSource();
			connection = dataSource.getConnection();
		} catch (PropertyVetoException | SQLException e) {
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
}
