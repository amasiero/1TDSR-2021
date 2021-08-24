package br.com.fiap.financas.factory.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryReflection {
	@SuppressWarnings("deprecation")
	public static Connection getConnection(Database database) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c = Class.forName("br.com.fiap.financas.factory.connection." + database.getValue() + "Connection");
		return ((MyConnection) c.newInstance()).getConnection();
	}
}
