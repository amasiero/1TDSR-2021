package br.com.fiap.financas.factory.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryReflection {
	public static Connection getConnection(Database database) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> c = Class.forName("br.com.fiap.financas.factory.connection." + database.getValue() + "Connection");
		return ((MyConnection) c.getDeclaredConstructor().newInstance()).getConnection();
	}
}
