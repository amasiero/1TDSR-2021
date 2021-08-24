package br.com.fiap.collection;

import java.util.function.Consumer;

public class ShowPerson implements Consumer<Person> {

	@Override
	public void accept(Person person) {
		System.out.println(person);
	}

}
