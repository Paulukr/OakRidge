package library.dao;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DatabaseUtility
{
	public static ComboPooledDataSource getDataSource() throws PropertyVetoException
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/library");
		cpds.setUser("postgres");
		cpds.setPassword("postgresql");

		// Optional Settings
cpds.setInitialPoolSize(5);
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
cpds.setMaxStatements(100);

		return cpds;
	}

	
}

