package br.com.fiap.rh.entities;

import java.util.Objects;

public class Analista extends Colaborador {

	private String senioridade;

	public Analista(String nome, Integer matricula) {
		super(nome, matricula);
	}

	public Analista(String nome, Integer matricula, Double salario, String senioridade) {
		super(nome, matricula, salario);
		this.senioridade = senioridade;
	}

	public String getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(String senioridade) {
		this.senioridade = senioridade;
	}

	@Override
	public Double calculaSalario() {
		switch (this.senioridade) {
		case "Junior":
			return this.salario * 1.05;
		case "Pleno":
			return this.salario * 1.15;
		case "Senior":
			return this.salario * 1.30;
		default:
			return this.salario;
		}
	}

	@Override
	public String toString() {
		return String.format("{nome: %s, matricula: %d, salario: %.2f, senioridade: %s}", super.getNome(),
				super.getMatricula(), super.getSalario(), this.getSenioridade());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.getNome(), super.getMatricula(), super.getSalario(), this.senioridade);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Analista))
			return false;
		if (o == this)
			return true;
		Analista analista = (Analista) o;
		return this.getNome().equals(analista.getNome()) && this.getSenioridade().equals(analista.getSenioridade())
				&& this.getMatricula() == analista.getMatricula() && this.getSalario() == analista.getSalario();
	}

}
