package br.com.fiap.receitas.model;

public class Ingrediente {
	private String quantidade;
	private String nome;
	
	public Ingrediente(String quantidade, String nome) {
		this.quantidade = quantidade;
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public String getNome() {
		return nome;
	}

}
