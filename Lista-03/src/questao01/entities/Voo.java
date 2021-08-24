package questao01.entities;

import java.time.LocalDate;

public class Voo {
	
	private Integer numero;
	private LocalDate data;
	private Boolean[] lugaresOcupados;
	
	public Voo(Integer numero, LocalDate data) {
		super();
		this.numero = numero;
		this.data = data;
		this.lugaresOcupados = new Boolean[100];
	}
	
	protected Voo(Integer numero, LocalDate data, Boolean[] lugaresOcupados) {
		this(numero, data);
		this.lugaresOcupados = lugaresOcupados;
	}
	
	public Integer getNumero() {
		return this.numero;
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
	public Integer proximoLivre() {
		for(int i = 0; i < this.lugaresOcupados.length; i++) {
			if(!this.lugaresOcupados[i]) {
				return i + 1;
			}
		}
		return null;
	}
	
	public int vagas() {
		int vagasDisponiveis = 0;
		for(int i = 1; i <= this.lugaresOcupados.length; i++) {
			if(!this.verifica(i)) vagasDisponiveis++;
		}
		return vagasDisponiveis; 
	}
	
	public Boolean verifica(int lugar) {
		return this.lugaresOcupados[lugar - 1];
	}
	
	public Boolean ocupa(int lugar) {
		if(this.verifica(lugar)) return false;
		this.lugaresOcupados[lugar - 1] = true;
		return true;
	}
	
	public Voo clone() {
		return new Voo(this.numero, this.data, this.lugaresOcupados);
	}

}
