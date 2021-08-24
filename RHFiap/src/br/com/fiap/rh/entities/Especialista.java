package br.com.fiap.rh.entities;

import java.util.Objects;

public class Especialista extends Colaborador {

	private Integer horasPlantao;
	
	public Especialista(String nome, Integer matricula) {
		super(nome, matricula);
	}
	
	public Especialista(String nome, Integer matricula, Double salario) {
		super(nome, matricula, salario);
	}
	
	public Especialista(String nome, Integer matricula, Double salario, Integer horasPlantao) {
		this(nome, matricula, salario);
		this.horasPlantao = horasPlantao;
	}

	public Integer getHorasPlantao() {
		return horasPlantao;
	}

	public void setHorasPlantao(Integer horasPlantao) {
		this.horasPlantao = horasPlantao;
	}
	
	@Override
	public String toString() {
		return String.format("{nome: %s, matricula: %d, salario: %.2f, horasPlantao: %d}", super.getNome(),
				super.getMatricula(), super.getSalario(), this.horasPlantao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.getNome(), super.getMatricula(), super.getSalario(), this.horasPlantao);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Especialista))
			return false;
		if (o == this)
			return true;
		Especialista especialista = (Especialista) o;
		return this.getNome().equals(especialista.getNome()) && this.horasPlantao == especialista.getHorasPlantao()
				&& this.getMatricula() == especialista.getMatricula() && this.getSalario() == especialista.getSalario();
	}

	@Override
	public Double calculaSalario() {
		double valorHora = this.salario / 22 * 8;
		return this.salario + (this.horasPlantao * valorHora);
	}

}
