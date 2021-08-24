package br.com.fiap.financas.entity;

public enum Type {
	INPUT("input"), 
	OUTPUT("output");
	
	private String value;
	
	private Type(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
