package br.com.fiap.financas.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.financas.entity.Transaction;
import br.com.fiap.financas.entity.Type;

public class TransactionRepository implements BaseRepository<Transaction> {

	private Connection conn;

	public TransactionRepository(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void save(Transaction t) throws SQLException {
		
		PreparedStatement stmt = this.conn.prepareStatement("select sq_transaction.nextval as id from dual");
		Long id = null;
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) id = rs.getLong("id");
		
		if (id != null) {
			String sql = 
					"insert into transactions(id, description, tdate, type, value)"
							+ " values(?, ?, ?, ?, ?)";
			
			stmt = this.conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			stmt.setString(2, t.getDescription());
			stmt.setDate(3, Date.valueOf(t.getDate()));
			stmt.setString(4, t.getType().getValue());
			stmt.setBigDecimal(5, t.getValue());
	
			stmt.execute();
		}
		this.desconnect();
	}

	@Override
	public void update(Transaction t) throws SQLException {

		// Text block -> Java 13 ou superior
		String sql = """ 
				 update transactions set description = ?, 
				 						 tdate = ?, 
				 						 type = ?, 
				 						 value = ? 
				 				     where id = ?
						
				""";

		PreparedStatement stmt = this.conn.prepareStatement(sql);
		
		stmt.setString(1, t.getDescription());
		stmt.setDate(2, Date.valueOf(t.getDate()));
		stmt.setString(3, t.getType().getValue());
		stmt.setBigDecimal(4, t.getValue());
		stmt.setLong(5, t.getId());

		stmt.executeUpdate();
		this.desconnect();
	}

	@Override
	public void delete(Long id) throws SQLException {
		String sql = "delete from transactions where id = ?";

		PreparedStatement stmt = this.conn.prepareStatement(sql);
		stmt.setLong(1, id);
		stmt.executeUpdate();
		this.desconnect();
	}

	@Override
	public Transaction findById(Long id) throws SQLException {

		String sql = "select * from transactions where id = ?";
		PreparedStatement stmt = this.conn.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			String description = rs.getString("description");
			LocalDate date = rs.getDate("tdate").toLocalDate();
			Type type = Type.valueOf(rs.getString("type"));
			BigDecimal value = rs.getBigDecimal("value");
			
			this.desconnect();
			return new Transaction(id, description, date, type, value);
		}
		
		this.desconnect();
		return null;
	}

	@Override
	public List<Transaction> listAll() throws SQLException {
		List<Transaction> transactions =  new ArrayList<>();
		PreparedStatement stmt = this.conn.prepareStatement("select * from transactions");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Long id = rs.getLong("id");
			String description = rs.getString("description");
			LocalDate date = rs.getDate("tdate").toLocalDate();
			Type type = Type.valueOf(rs.getString("type"));
			BigDecimal value = rs.getBigDecimal("value");

			transactions.add(new Transaction(id, description, date, type, value));
		}
		
		this.desconnect();
		return transactions;
	}
	
	private void desconnect() throws SQLException {
		if (!this.conn.isClosed()) {
			this.conn.close();
		}
	}

}
