package br.com.fiap.estacionamento.model;

public class Estacionamento {
	
	private Ticket[] tickets;
	private int quantidadeCarros;
	
	public Estacionamento(int capacidade) {
		this.tickets = new Ticket[capacidade];
		this.quantidadeCarros = 0;
	}
	
	public void adiciona(Ticket ticket) {
		if(this.quantidadeCarros >= this.tickets.length) {
			System.err.println("Capacidade máxima de veículos atingida.");
			return;
		}
		this.tickets[this.quantidadeCarros] = ticket;
		this.quantidadeCarros++;
	}
	
	public void remove(Ticket ticket) {
		ticket.registraSaida();
		ticket.imprimeRecibo();
		
		for(int i = 0; i <= this.quantidadeCarros; i++) {
			if(ticket.getId() == this.tickets[i].getId()) {
				for(int j = i; j < this.quantidadeCarros - 1; j++) {
					this.tickets[j] = this.tickets[j + 1];
				}
				this.quantidadeCarros--;
				break;
			}
		}
		
	}
	
	public Ticket consulta(int id) {
		for(int i = 0; i<= this.quantidadeCarros; i++) {
			if(this.tickets[i].getId() == id) {
				return this.tickets[i];
			}
		}
		return null;
	}

}
