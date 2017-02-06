package library.model.dao;

import java.beans.PropertyVetoException;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import library.controller.ErrorList;

public class DatabaseUtility {
	private static final Logger logger = Logger.getLogger(DatabaseUtility.class);

	public static ComboPooledDataSource getDataSource() throws PropertyVetoException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(ErrorList.DataSourse, e);
			throw new RuntimeException(e);
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
		cpds.setTestConnectionOnCheckout(true);

		return cpds;
	}

}
