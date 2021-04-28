package br.com.fiap.rh;

import br.com.fiap.rh.entities.Analista;
import br.com.fiap.rh.entities.Especialista;
import br.com.fiap.rh.entities.Gerente;

public class Application {

	public static void main(String[] args) {
		Gerente gerente = new Gerente("Astolfo", 1521, 14000., 50);
		Gerente gerente2 = new Gerente("Astolfo Junior", 1523, 14500., 75);
		Gerente gerente3 = new Gerente("Astolfo Terceiro", 1522, 18000., 100);

		Analista analista = new Analista("Juvenal", 102, 8000., "Pleno");
		Analista analista2 = new Analista("Juvenal Segundo", 103, 9600., "Senior");
		Analista analista3 = new Analista("Juveneto", 104, 6000., "Junior");

		Especialista especialista = new Especialista("Roberval", 2400, 10000., 50);
		Especialista especialista2 = new Especialista("Roberval Filho", 2401, 15000., 30);
		Especialista especialista3 = new Especialista("Roberval Seila", 2402, 12000., 80);

		Gerente[] gerentes = new Gerente[3];
		gerentes[0] = gerente;
		gerentes[1] = gerente2;
		gerentes[2] = gerente3;

		Analista[] analistas = { analista, analista2, analista3 };
		System.out.println(analistas[2]);

		Especialista[] especialistas = { especialista, especialista2, especialista3 };

		// Folha de pagamento
		double total = 0.;

		// Utilizando o while (executa 0 a Infinito)
		int indice = 0;

		while (indice < 3) {
			total += gerentes[indice].calculaSalario();
			indice++; // indice = indice + 1 ou indice += 1
		}

		// Utilizando o for (executa n vezes)
		for (int i = 0; i < 3; i++) {
			total += analistas[i].calculaSalario();
		}

		// Utilizando o do..while (executa 1 a Infinito)
		indice = 0;
		do {
			total += especialistas[indice].calculaSalario();
			indice++;
		} while (indice < 3);

		System.out.println(String.format("O total da folha de pagamento é R$ %.2f.", total));

	}

}
