package questao01.entities;

import java.time.LocalDate;

public class VooFumantes extends Voo {
	
	private Integer cadeirasFumantes;
	private Integer maxVagas;
	
	public VooFumantes(Integer numero, LocalDate data, Integer maxVagas, Integer cadeirasFumantes) {
		super(numero, data, new Boolean[maxVagas]);
		this.maxVagas = maxVagas;
		this.cadeirasFumantes = cadeirasFumantes;
	}
	
	public Integer maxVagas() {
		return this.maxVagas;
	}

	public Integer cadeirasFumantes() {
		return this.cadeirasFumantes;
	}
	
	public char tipo(Integer lugar) {
		int posicaoFumante = this.maxVagas - this.cadeirasFumantes;
		int posicaoLugar = lugar - 1;
		return posicaoLugar >= posicaoFumante ? 'F' : 'N';
	}
}
