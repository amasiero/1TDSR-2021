package br.com.fiap.receitas;

import javax.swing.JOptionPane;

import br.com.fiap.receitas.dao.ReceitaDAO;

public class Main {

	public static void main(String[] args) {
		ReceitaDAO dao = new ReceitaDAO();
		dao.lista().forEach(receita -> System.out.println(receita.getNome()));
		
		String nomeReceita = JOptionPane.showInputDialog("Insira o nome da receita");
		System.out.println(nomeReceita);
	}

}
