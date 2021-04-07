public class Conta {

	private String cliente;
	private int numero;
	private double saldo;

	public Conta(String cliente, int numero) {
		this.cliente = cliente;
		this.numero = numero;
		this.saldo = 0.0;
	}

	public Conta(String cliente, int numero, double saldo) {
		this(cliente, numero); // Chamada do construtor com dois parâmetros
		this.saldo = saldo;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return this.numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public String consultaSaldo() {
		return String.format("R$ %.2f", this.saldo);
	}

	public void deposita(double valor) {
		if (valor <= 0) {
			System.out.println("Para depósito o valor deve ser positivo e maior do que zero.");
			return;
		}
		this.saldo += valor;
	}
	
	public double saca(double valor) {
		if(valor <= 0) {
			System.out.println("Para saque o valor deve ser positivo e maior do que zero.");
			return 0.0;
		}
		
		if(valor >= this.saldo) {
			System.out.println("Saldo insulficiente.");
			return 0.0;
		}
		
		this.saldo -= valor;
		return valor;
	}
	
	public void  transfere(double valor, Conta conta) {
		double saque = this.saca(valor);
		if(saque == 0.0) return;
		conta.deposita(saque);
	}

}
