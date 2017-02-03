package library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ExampleQuery {
	public static int query() throws SQLException
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int resultSetSize = 0;
		try
		{
			ComboPooledDataSource dataSource = DatabaseUtility.getDataSource();
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("SELECT * FROM title_table");
			
			System.out.println("\n\nHey YOU \n try");
			
			System.out.println("The Connection Object is of Class: " + connection.getClass());
			System.out.println("\n\nHey YOU \n class");
			resultSet = pstmt.executeQuery();
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
