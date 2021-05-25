package com.andreymasiero.exceptions;

public class Application {

	public static void main(String[] args) {
		System.out.println("Inicio do método main");
		metodo1();
		System.out.println("Fim do método main");
	}

	private static void metodo1() {
		System.out.println("Inicio do método 1");
		metodo2();
		System.out.println("Fim do método 1");

	}

	private static void metodo2() {
		System.out.println("Inicio do método 2");

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		for (int i = 0; i <= array.length; i++) {
			System.out.println(String.format("Elemento número: %d", array[i]));
		}

		System.out.println("Fim do método 2");
	}

}
