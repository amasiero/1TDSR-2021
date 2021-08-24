package br.com.fiap.financas.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		Statement stmt = this.conn.createStatement();

		String sql = String.format(
				"insert into transactions(id, description, tdate, type, value)"
						+ " values(sq_transaction.nextval, '%s', to_date('%s', 'yyyy-mm-dd'), '%s', %s)",
				t.getDescription(), t.getDate(), t.getType().getValue(), t.getValue().toString());

		stmt.executeUpdate(sql);
	}

	@Override
	public void update(Transaction t) throws SQLException {
		Statement stmt = this.conn.createStatement();

		String sql = String.format(
				"update transactions set description = '%s', " + "tdate = to_date('%s', 'yyyy-mm-dd'), " + "type = '%s',"
						+ "value = %s" + "where id = %d",
				t.getDescription(), t.getDate(), t.getType().getValue(), t.getValue().toString(), t.getId());

		stmt.executeUpdate(sql);
	}

	@Override
	public void delete(Long id) throws SQLException {
		Statement stmt = this.conn.createStatement();

		String sql = String.format("delete from transactions where id = %d", id);

		stmt.executeUpdate(sql);

	}

	@Override
	public Transaction findById(Long id) throws SQLException {
		Statement stmt = this.conn.createStatement();

		String sql = String.format("select * from transactions where id = %d", id);

		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			String description = rs.getString("description");
			LocalDate date = rs.getDate("tdate").toLocalDate();
			Type type = Type.valueOf(rs.getString("type"));
			BigDecimal value = rs.getBigDecimal("value");

			return new Transaction(id, description, date, type, value);
		}

		return null;
	}

	@Override
	public List<Transaction> listAll() throws SQLException {
		List<Transaction> transactions =  new ArrayList<>();
		Statement stmt = this.conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from transactions");

		while (rs.next()) {
			Long id = rs.getLong("id");
			String description = rs.getString("description");
			LocalDate date = rs.getDate("tdate").toLocalDate();
			Type type = Type.valueOf(rs.getString("type"));
			BigDecimal value = rs.getBigDecimal("value");

			transactions.add(new Transaction(id, description, date, type, value));
		}

		return transactions;
	}

}
