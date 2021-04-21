package br.com.fiap.rh;

import br.com.fiap.rh.entities.Analista;
import br.com.fiap.rh.entities.Gerente;

public class Application {

	public static void main(String[] args) {
		Gerente gerente = new Gerente("Astolfo", 1521, 14000.);
		Analista analista = new Analista("Juvenal", 102, 8000., "Pleno");
		System.out.println(gerente);
		System.out.println(analista);
		gerente.equals(analista);
		
	}

}
