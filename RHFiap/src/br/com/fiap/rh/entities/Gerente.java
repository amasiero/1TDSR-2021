package br.com.fiap.rh.entities;

import java.util.Objects;

public class Gerente extends Colaborador { // classe Gerente é subclasse de Colaborador

	private Integer meta;

	public Gerente(String nome, Integer matricula) {
		super(nome, matricula);
	}

	public Gerente(String nome, Integer matricula, Double salario) {
		super(nome, matricula, salario);
	}

	public Gerente(String nome, Integer matricula, Double salario, Integer meta) {
		this(nome, matricula, salario);
		this.meta = meta;
	}

	public Integer getMeta() {
		return meta;
	}

	public void setMeta(int meta) {
		this.meta = meta;
	}
	
	@Override
	public Double calculaSalario() {
		return this.salario *  (1 + (meta / 100));
	}

	@Override
	public String toString() {
		return String.format("{nome: %s, matricula: %d, salario: %.2f, meta: %d}", this.nome,
				this.matricula, this.salario, this.meta);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nome, this.matricula, this.salario, this.meta);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Gerente)) { // Verifico se é a instância do tipo do meu objeto
			return false;
		}

		if (o == this) { // Será que o parâmetro não sou eu mesmo?
			return true;
		}
		
		Gerente gerente = (Gerente) o; 
		return this.getNome().equals(gerente.getNome()) && this.getMatricula() == gerente.getMatricula()
				&& this.getSalario() == gerente.getSalario() && this.getMeta() == gerente.getMeta();
	}

}
