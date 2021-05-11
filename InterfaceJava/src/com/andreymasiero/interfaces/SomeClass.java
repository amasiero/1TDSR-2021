package com.andreymasiero.interfaces;

public class SomeClass {
	
	private Integer someValue;
	
	public SomeClass(Integer someValue) {
		super();
		this.someValue = someValue;
	}
	
	public Integer getSomeValue() {
		return someValue;
	}
	
	public Boolean evaluate(Predicate predicate) {
		return predicate.rule(someValue);
	}

}
