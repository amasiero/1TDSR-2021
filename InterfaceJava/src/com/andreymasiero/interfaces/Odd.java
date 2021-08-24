package com.andreymasiero.interfaces;

public class Odd implements Predicate {

	@Override
	public Boolean rule(Integer someValue) {
		return someValue % 2 != 0;
	}

}
