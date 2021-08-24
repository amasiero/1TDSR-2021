package br.com.fiap.rh.entities;

public abstract class Colaborador { // Superclasse | classe Colaborador é uma subclasse de Object
	protected String nome;
	protected Integer matricula;
	protected Double salario;

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
	
	public abstract Double calculaSalario();

}
