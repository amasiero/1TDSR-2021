package br.com.fiap.financas;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.financas.entity.Transaction;
import br.com.fiap.financas.entity.Type;
import br.com.fiap.financas.repository.TransactionRepository;

public class Main {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB", "SYS as SYSDBA",
					"Oradoc_db1");
			Transaction transaction = new Transaction("Salário", LocalDate.of(2021, 8, 17), Type.INPUT,
					new BigDecimal(4500.0));
			TransactionRepository repository = new TransactionRepository(conn);
			repository.save(transaction);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
}
