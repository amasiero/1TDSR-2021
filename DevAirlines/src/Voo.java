
public class Voo {
	private int numero;
	private Data data;
	private final int maxLugares; //Constante
	private int ocupados;
	
	public Voo(int numero, Data data) {
		this.numero = numero;
		this.data = data;
		this.maxLugares = 100;
	}
	
	private Voo(int numero, Data data, int ocupados) {
		this(numero, data);
		this.ocupados = ocupados;
	}
	
	public int getVoo() {
		return this.numero;
	}
	
	public Data getData() {
		return this.data;
	}
	
	public int proximoLivre() {
		return this.ocupados + 1;
	}
	
	public boolean verifica(int lugar) {
		return lugar > this.ocupados && vagas() > 0;
	}
	
	public boolean ocupa(int lugar) {
		if(verifica(lugar)) {
			this.ocupados++;
			return true;
		}
		return false;
	}
	
	public int vagas() {
		return this.maxLugares - this.ocupados;
	}
	
	public Voo clone() {
		return new Voo(this.numero, this.data, this.ocupados);
	}
	
}
