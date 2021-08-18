package br.com.fiap.tarefas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		// OJDBC -> Oracle Java Database Conectivity
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCLCDB", 
					"SYS as SYSDBA",
					"Oradoc_db1");
			
			System.out.println("Conectou com sucesso.");
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into tb_tarefa(id, descricao, data_limite)"
					+ "values(sq_tarefa.nextval, 'Deitar e domir', "
					+ "to_date('17/08/2021', 'dd/mm/yyyy'))");
			
			stmt.executeUpdate("update tb_tarefa set feita=1 where descricao like '%Deitar%'");
			
			stmt.executeUpdate("delete from tb_tarefa where id = 2");
			
			ResultSet rs = stmt.executeQuery("select * from tb_tarefa");
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				LocalDate dataLimite = rs.getDate("data_limite").toLocalDate();
				Boolean feita = rs.getBoolean("feita");
				
				System.out.println(String.format("Tarefa = {%d, %s, %s, %s}", 
						id, descricao, dataLimite.toString(), feita));
			}
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro na conexão com o banco de dados.");
			System.err.println(e.getMessage());
		}

	}

}
