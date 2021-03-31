
public class Application {

	public static void main(String[] args) {
		Conta c = new Conta(); // Instancia do objeto

		c.setCliente("Gloria Maria"); // Atribuição de valores
		c.setNumero(1);
		c.setSaldo(400.0);

		System.out.println(c.getCliente()); // Consulta de valores
		System.out.println(c.getNumero());

		double saldo = c.getSaldo();

		if (saldo > 200) {
			System.out.println("Oferecer investimento.");
		} else {
			System.out.println("Oferecer emprestimo.");
		}

		System.out.println(c.consultaSaldo());

	}

}
