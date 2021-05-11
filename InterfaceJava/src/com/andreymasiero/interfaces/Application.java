package com.andreymasiero.interfaces;

public class Application {

	public static void main(String[] args) {
		SomeClass sc = new SomeClass(4);
		System.out.println(sc.evaluate(new Even()));
		System.out.println(sc.evaluate(new Odd()));
		System.out.println(sc.evaluate(value -> value % 3 == 0));

	}

}
