package br.com.fiap.receitas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.receitas.model.Ingrediente;
import br.com.fiap.receitas.model.Receita;

public class ReceitaDAO {

	private static List<Receita> receitas = new ArrayList<>();
	
	static {
		geraIdEAdiciona(
				new Receita(
						"Pizza", 
						"Coloca tudo no topo e assa", 
						List.of(
								new Ingrediente("400g", "Farinha da boa"),
								new Ingrediente("400ml", "Água"),
								new Ingrediente("100g", "Molho de tomate"),
								new Ingrediente("500g", "Queijo")
								)
						)
				);
		
		geraIdEAdiciona(
				new Receita(
						"Feijão", 
						"Coloca água, joga na panela e cozinha", 
						List.of(
								new Ingrediente("400g", "Feijão"),
								new Ingrediente("1000ml", "Água"),
								new Ingrediente("5g", "Sal")
								)
						)
				);
	}
	
	
	public void adiciona(Receita receita) {
		geraIdEAdiciona(receita);
	}
	
	private static void geraIdEAdiciona(Receita receita) {
		if(receita.getId() != null)
			receita.setId(receitas.size() + 1l);
		receitas.add(receita);
	}
	
	public List<Receita> lista() {
		return receitas;
	}
	
	public void remove(Long id) {
		receitas = receitas
				.stream()
				.filter(receita -> receita.getId() != id)
				.toList();
	}
	
	public Receita consulta(Long id) {
		return receitas
				.stream()
				.filter(receita -> receita.getId() == id)
				.findFirst()
				.get();
	}
	
	public void altera(Receita receita) {
		remove(receita.getId());
		adiciona(receita);
	}
	
}
