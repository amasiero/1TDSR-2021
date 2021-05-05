package questao02.entities;

public class EquipamentoCorrigido extends Equipamento {

	private Integer mesCorrente;
	private Integer[] mesesCompra;

	public EquipamentoCorrigido(Integer numeroEquipamentos) {
		super(numeroEquipamentos);
		this.mesCorrente = 1;
		this.mesesCompra = new Integer[numeroEquipamentos];
	}

	public Integer getMesCompra(Integer numero /* posicao do vetor */) {
		return this.mesesCompra[numero];
	}

	public void setMesCompra(Integer numero, Integer mesCompra) {
		this.mesesCompra[numero] = mesCompra;
	}

	public void corrige(Integer percentual) {
		for (int i = 0; i < this.mesesCompra.length; i++) {
			if (this.mesesCompra[i] == this.mesCorrente) {
				this.setValor(i, this.getValor(i) * (percentual / 100));
			}
		}

		if (this.mesCorrente == 12) {
			this.mesCorrente = 1;
		} else {
			this.mesCorrente++;
		}
	}

	public void substitui(EquipamentoCorrigido outro) {
		if (this.getNumeroEquipamentos() == outro.getNumeroEquipamentos()) {
			for (int i = 0; i < this.getNumeroEquipamentos(); i++) {
				this.setValor(i, outro.getValor(i));
				this.setMesCompra(i, outro.getMesCompra(i));
			}
		}
	}

}
