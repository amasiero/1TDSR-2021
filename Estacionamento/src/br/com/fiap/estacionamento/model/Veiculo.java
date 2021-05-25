package br.com.fiap.estacionamento.model;

public class Veiculo {
	private String marca;
	private String modelo;
	private String placa;
	
	public Veiculo(String marca, String modelo, String placa) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}
	
}
