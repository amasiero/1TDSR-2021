package br.com.fiap.financas;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.financas.entity.Transaction;
import br.com.fiap.financas.entity.Type;
import br.com.fiap.financas.factory.connection.ConnectionFactoryReflection;
import br.com.fiap.financas.factory.connection.Database;
import br.com.fiap.financas.repository.TransactionRepository;

public class Main {
	public static void main(String[] args) {
		try {
			
			Transaction transaction = new Transaction("Salario", LocalDate.of(2021, 9, 1), Type.INPUT,
					new BigDecimal(4500.0));
			TransactionRepository repository = new TransactionRepository(ConnectionFactoryReflection.getConnection(Database.ORACLE));
			repository.save(transaction);
			
		} catch (SQLException | ClassNotFoundException | IOException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} 

	}
}
