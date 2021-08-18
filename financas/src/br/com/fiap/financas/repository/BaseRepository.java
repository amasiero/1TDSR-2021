package br.com.fiap.financas.repository;

import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<T> {
	void save(T t) throws SQLException;
	void update(T t) throws SQLException;
	void delete(Long id) throws SQLException;
	T findById(Long id) throws SQLException;
	List<T> listAll() throws SQLException;
}
