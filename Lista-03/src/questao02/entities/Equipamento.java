package questao02.entities;

public class Equipamento {
	
	private Integer[] valores;
	
	public Equipamento(int numeroEquipamentos) {
		this.valores = new Integer[numeroEquipamentos];
	}
	
	public Integer getNumeroEquipamentos() {
		return this.valores.length;
	}
	
	public Integer getValor(Integer numero) {
		return this.valores[numero];
	}
	
	public void setValor(Integer numero, Integer valor) {
		this.valores[numero] = valor;
	}

}
