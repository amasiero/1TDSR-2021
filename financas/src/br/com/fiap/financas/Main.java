package br.com.fiap.financas;

import java.io.IOException;
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
			
			Transaction transaction = new Transaction("Restaurante", LocalDate.of(2021, 8, 24), Type.OUTPUT,
					new BigDecimal(30.90));
			TransactionRepository repository = new TransactionRepository(ConnectionFactoryReflection.getConnection(Database.ORACLE));
			repository.save(transaction);
			
		} catch (SQLException | ClassNotFoundException | IOException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} 

	}
}
