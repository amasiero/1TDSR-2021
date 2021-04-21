package br.com.fiap.rh.entities;

public class Colaborador {
	private String nome;
	private Integer matricula;
	private Double salario;

	public Colaborador(String nome, Integer matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

	public Colaborador(String nome, Integer matricula, Double salario) {
		this(nome, matricula);
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getMatricula() {
		return matricula;
	}

}
