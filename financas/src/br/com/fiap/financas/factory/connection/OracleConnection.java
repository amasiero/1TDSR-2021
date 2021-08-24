package br.com.fiap.financas.factory.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnection implements MyConnection {
	
	private Properties props;
	
	public OracleConnection()  throws IOException {
		this.props = new Properties();
		this.props.load(new FileInputStream("application.properties"));
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(
				this.props.getProperty("database.url"), 
				this.props.getProperty("database.user"),
				this.props.getProperty("database.password"));
	}

}
