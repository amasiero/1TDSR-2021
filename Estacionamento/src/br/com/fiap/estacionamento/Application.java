package br.com.fiap.estacionamento;

import java.time.LocalDateTime;

import br.com.fiap.estacionamento.model.Estacionamento;
import br.com.fiap.estacionamento.model.Ticket;
import br.com.fiap.estacionamento.model.Veiculo;

public class Application {

	public static void main(String[] args) {
		
		Ticket t1 = new Ticket(new Veiculo("Citroen", "C3", "ABC-1234"), LocalDateTime.now());
		Ticket t2 = new Ticket(new Veiculo("Citroen", "C4 Cactus", "BAC-7321"), LocalDateTime.now());
		
		Estacionamento estacionamento = new Estacionamento(2);
		
		estacionamento.adiciona(t1);
		estacionamento.adiciona(t2);
		
		System.out.println(estacionamento.consulta(1));
		System.out.println(estacionamento.consulta(2));
		
		estacionamento.remove(t1);
		estacionamento.remove(t2);
		
	}

}
