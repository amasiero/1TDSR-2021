package br.com.fiap.receitas.model;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	private Long id;
	private String nome;
	private String modoPreparo;
	private List<Ingrediente> ingredientes;
	
	public Receita(String nome) {
		super();
		this.nome = nome;
		this.ingredientes = new ArrayList<>();
	}
	
	public Receita(String nome, String modoPreparo) {
		this(nome);
		this.modoPreparo = modoPreparo;
	}
	
	public Receita(String nome, String modoPreparo, List<Ingrediente> ingredientes) {
		this(nome, modoPreparo);
		this.ingredientes = ingredientes;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public String getNome() {
		return nome;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public void adicionaIngrediente(Ingrediente ingrediente) {
		ingredientes.add(ingrediente);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
