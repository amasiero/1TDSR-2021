
public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	// Construtor recebe dia, mes e ano. Valida os valores.
	// Caso positivo atribui aos atributos da classe.
	// Caso negativo atribui o valor 1 para todos os elementos da data.
	public Data(int dia, int mes, int ano) {
		if(dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1900) {
			this.dia = 1;
			this.mes = 1;
			this.ano = 1;
		} else {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
	}
	
	// Getters dos 3 atributos
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
	
	// getMesExtenso onde vai transformar o n�mero do m�s para texto
	public String getMesExtenso() {
		switch(this.mes) {
			case 1:
				return "Janeiro";
			case 2:
				return "Fevereiro";
			case 3:
				return "Mar�o";
			case 4:
				return "Abril";
			case 5:
				return "Maio";
			case 6:
				return "Junho";
			case 7: 
				return "Julho";
			case 8:
				return "Agosto";
			case 9:
				return "Setembro";
			case 10:
				return "Outubro";
			case 11:
				return "Novembro";
			case 12:
				return "Dezembro";
			default: // else
				return "M�s inexistente";
		}
	}
	
	// isBissexto para verificar se o ano � bissexto. Retorna verdadeiro ou falso.
	public boolean isBissexto() {
		return (this.ano % 100) != 0 && ((this.ano % 4) == 0 || (this.ano % 400) == 0);
	}
	
	// m�todo compara
	// recebe como par�metro um objeto Data
	// retorna:
	// - 0 se iguais
	// - 1 se objeto maior que o par�metro
	// - (-1) se objeto menor que o par�metro
	public int compara(Data data) {
		int diffDia = this.dia - data.getDia();
		int diffMes = this.mes - data.getMes();
		int diffAno = this.ano - data.getAno();
		
		// Early return function
		if(diffAno > 0) return 1;
		if(diffAno < 0) return -1;
		if(diffMes > 0) return 1;
		if(diffMes < 0) return -1;
		if(diffDia > 0) return 1;
		if(diffDia < 0) return -1;
		return 0;
	}
		
	// clone, cria um novo objeto do tipo data.
	public Data clone() {
		return new Data(dia, mes, ano);
	}

}
