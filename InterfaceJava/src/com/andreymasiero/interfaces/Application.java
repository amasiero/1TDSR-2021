package com.andreymasiero.interfaces;

public class Application {

	public static void main(String[] args) {
		SomeClass sc = new SomeClass(4);
		Predicate even = value -> value % 2 == 0;
		System.out.println(sc.evaluate(even));
		System.out.println(sc.evaluate(new Odd()));
		System.out.println(sc.evaluate(value -> value % 3 == 0));

	}

}
