package br.com.fiap.rh;

import br.com.fiap.rh.entities.Analista;
import br.com.fiap.rh.entities.Colaborador;
import br.com.fiap.rh.entities.Especialista;
import br.com.fiap.rh.entities.Gerente;

public class App {

	public static void main(String[] args) {
		// Polimorfismo
		
		Colaborador[] colaboradores = {
				new Gerente("Astolfo", 1521, 14000., 50),
				new Gerente("Astolfo Junior", 1523, 14500., 75),
				new Gerente("Astolfo Terceiro", 1522, 18000., 100),
				new Analista("Juvenal", 102, 8000., "Pleno"),
				new Analista("Juvenal Segundo", 103, 9600., "Senior"),
				new Analista("Juveneto", 104, 6000., "Junior"),
				new Especialista("Roberval", 2400, 10000., 50),
				new Especialista("Roberval Filho", 2401, 15000., 30),
				new Especialista("Roberval Seila", 2402, 12000., 80)
		};
		
		double total = 0.0;
		
		for(int i = 0; i < colaboradores.length; i++) {
			total += colaboradores[i].calculaSalario();
		}
		
		exibePessoa(colaboradores[2]);
		exibePessoa(colaboradores[5]);
		exibePessoa(colaboradores[0]);
		
		System.out.println(String.format("O total da folha de pagamento é R$ %.2f.", total));
	}
	
	// Prefira utilizar a superclasse em parâmetros e retornos de método.
	private static void exibePessoa(Colaborador colaborador) {
		System.out.println(colaborador);
	}

}
