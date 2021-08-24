package br.com.fiap.financas.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
	
	private Long id;
	private String description;
	private LocalDate date;
	private Type type;
	private BigDecimal value;
	
	public Transaction(String description, LocalDate date, Type type, BigDecimal value) {
		super();
		this.description = description;
		this.date = date;
		this.type = type;
		this.value = value;
	}

	public Transaction(Long id, String description, LocalDate date, Type type, BigDecimal value) {
		this(description, date, type, value);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDate() {
		return date;
	}

	public Type getType() {
		return type;
	}

	public BigDecimal getValue() {
		return value;
	}
	
}
