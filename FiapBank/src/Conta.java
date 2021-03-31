
public class Conta {
	private String cliente;
	private int numero;
	private double saldo;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String clienteRecebido) {
		cliente = clienteRecebido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numeroRecebido) {
		numero = numeroRecebido;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldoRecebido) {
		if (saldoRecebido > 0) {
			saldo = saldoRecebido;
		} else {
			System.err.println("O saldo informado deve ser maior que zero.");
		}
	}
	
	public String consultaSaldo() {
		return String.format("R$ %.2f", saldo);
	}
}
