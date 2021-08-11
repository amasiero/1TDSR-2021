package br.com.fiap.newairlines.model;

import java.util.Objects;

public class Cadeira {
	
	private Long numero;
	private Boolean ocupada;
	
	public Cadeira(Long numero) {
		this.numero = numero;
		this.ocupada = true;
	}

	public Long getNumero() {
		return numero;
	}

	public Boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(Boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	public int hashCode() {
		return Objects.hash(this.numero, this.ocupada);
	}
	
	
}
