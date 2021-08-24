package br.com.fiap.financas.factory.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface MyConnection {
	Connection getConnection() throws SQLException, ClassNotFoundException;
}
