import javax.swing.JOptionPane;

public class Application {

	public static void main(String[] args) {
		Conta conta = new Conta("Maria Joaquina", 1); // Instancia do objeto
		Conta conta2 = new Conta("Gloria Maria", 2);
		
		String valorInformado = JOptionPane.showInputDialog("Informe o valor de dep�sito."); // Declarado
		double valor = Double.parseDouble(valorInformado);
		
		conta.deposita(valor);

		valorInformado = JOptionPane.showInputDialog("Informe o valor de transfer�ncia."); // Reuso
		valor = Double.parseDouble(valorInformado);

		conta.transfere(valor, conta2);
		
		JOptionPane.showMessageDialog(null, String.format("O saldo da conta � R$ %.2f", conta.getSaldo()));
		JOptionPane.showMessageDialog(null, String.format("O saldo da conta � R$ %.2f", conta2.getSaldo()));

	}

}

// Para cada tipo primitivo, o Java tem uma classe que o representa
// double -> Double
// int -> Integer
// char -> Char
