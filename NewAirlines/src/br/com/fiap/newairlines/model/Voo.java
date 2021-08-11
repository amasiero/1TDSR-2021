package br.com.fiap.newairlines.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Voo {
	
	private Long numero;
	private LocalDateTime data;
	private final Long MAX_PASSAGEIROS = 100L;
	private List<Cadeira> vagas = new ArrayList<>();
	
	public Voo(Long numero, LocalDateTime data) {
		super();
		this.numero = numero;
		this.data = data;
	}
	
	private Voo(Long numero, LocalDateTime data, List<Cadeira> vagas) {
		this(numero, data);
		this.vagas = vagas;
	}
	
	public Long getVoo() {
		return numero;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Long proximoLivre() {
		return  this.vagas.isEmpty() ?
				1 :
				this.vagas.get(this.vagas.size() - 1).getNumero() + 1;
	}
	
	public Boolean verifica(Long numero) {
		for(Cadeira cadeira : vagas) {
			if(cadeira.getNumero() == numero) {
				return cadeira.isOcupada();
			}
		}
		return false;
	}
	
	public Boolean ocupa(Long numero) {
		if(verifica(numero)) {
			return false;
		}
		
		if((this.vagas.size()) + 1 > 100) {
			return false;
		}
		
		this.vagas.add(new Cadeira(numero));
		return true;
	}
	
	public Long vagas() {
		return MAX_PASSAGEIROS - this.vagas.size();
	}
	
	public Voo clone() {
		return new Voo(this.numero, this.data, this.vagas);
	}

}
