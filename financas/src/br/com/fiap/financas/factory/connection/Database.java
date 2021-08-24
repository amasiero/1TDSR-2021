package br.com.fiap.financas.factory.connection;

public enum Database {
	ORACLE("Oracle"), 
	POSTGRESQL("PostgreSQL"),
	MYSQL("MySQL"),
	MONGO_DB("MongoDB");
	
	private String value;
	
	private Database(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
