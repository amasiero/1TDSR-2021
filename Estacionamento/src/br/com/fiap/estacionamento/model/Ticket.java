package br.com.fiap.estacionamento.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ticket {
	
	private Long id;
	private Veiculo veiculo;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private Double valor;
	private static Long geradorId = 0l; // uuid
	
	public Ticket(Veiculo veiculo, LocalDateTime entrada) {
		geradorId++;
		this.id = geradorId;
		this.veiculo = veiculo;
		this.entrada = entrada;
	}

	public Long getId() {
		return id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public Double getValor() {
		return valor;
	}

	public static Long getGeradorId() {
		return geradorId;
	}
	
	
	public void incremetaId() {
		geradorId++;
	}
	
	public void registraSaida() {
		// this.saida = LocalDateTime.parse("2021-05-25T22:00:00");
		this.saida = LocalDateTime.now();
		long horas = this.entrada.until(this.saida, ChronoUnit.HOURS);
		long minutos = this.entrada.until(this.saida, ChronoUnit.MINUTES);
		
		long horasEmMinutos = horas * 60;
		minutos -= horasEmMinutos;
		this.valor = horas * 5.;
		this.valor = minutos > 0 ? this.valor + 5. : this.valor;
	}
	
	public void imprimeRecibo() {
		String recibo = String.format("%s %s - Placa: %s\nEntrada: %s\nSaída: %s\nR$ %.2f",
				this.veiculo.getMarca(), this.veiculo.getModelo(), this.veiculo.getPlaca(),
				this.entrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
				this.saida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
				this.valor);
		System.out.println(recibo);
	}

}
