package br.com.fiap.collection;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CollectionTest {
	
	public static void main(String[] args) {
		List<Person> people = getPeople();
		
		// Imperativa
		// for tradicional
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		System.out.println("\n------------------------------\n");
		
		// for each
		for (Person person : people) {
			System.out.println(person);
		}
		System.out.println("\n------------------------------\n");
		
		// Declarativa
		// foreach -> a partir do Java 8
		ShowPerson sp = new ShowPerson();
		people.forEach(sp);
		System.out.println("\n------------------------------\n");
		
		people.forEach(new ShowPerson());
		System.out.println("\n------------------------------\n");
		
		// Classe anonima
		Consumer<Person> consumer = new Consumer<Person>() {

			@Override
			public void accept(Person person) {
				System.out.println(person);		
			}
			
		};
		
		people.forEach(consumer);
		System.out.println("\n------------------------------\n");
				
		people.forEach(new Consumer<Person>() {

			@Override
			public void accept(Person person) {
				System.out.println(person);		
			}
			
		});
		System.out.println("\n------------------------------\n");
		
		// Lambda Expression
		people.forEach((Person person) -> {
			System.out.println(person);
		});
		System.out.println("\n------------------------------\n");
		
		people.forEach((person) -> {
			System.out.println(person);
		});
		System.out.println("\n------------------------------\n");
		
		people.forEach(person -> {
			System.out.println(person);
		});
		System.out.println("\n------------------------------\n");
		
		people.forEach(person -> System.out.println(person));
		System.out.println("\n------------------------------\n");
		
		//Method Reference
		people.forEach(System.out::println);
		System.out.println("\n------------------------------\n");
		
		// Stream API
		List<Person> females = people
				.stream()
				.filter(person -> person.getGender().equals("Feminina"))
				.toList();
		females.forEach(System.out::println);
		System.out.println("\n------------------------------\n");
		
		List<PersonDTO> peopleDto = people
				.stream()
				.map(person -> new PersonDTO(person.getName(), person.getAge()))
				.toList();
		peopleDto.forEach(System.out::println);
		System.out.println("\n------------------------------\n");
		
		List<PersonDTO> peopleDtoUnder18 = people
				.stream()
				.filter(person -> person.getAge() < 18)
				.map(person -> new PersonDTO(person.getName(), person.getAge()))
				.toList();
		peopleDtoUnder18.forEach(System.out::println);
		System.out.println("\n------------------------------\n");
		
		boolean todosAbaixo25 = people
				.stream()
				.allMatch(person -> person.getAge() <= 25);
		System.out.println(
				String.format(
						"Todos elementos são menores que 25 anos? Resposta: %s", 
						todosAbaixo25 ? "Sim" : "Não"
							)
				);
		System.out.println("\n------------------------------\n");
		
		boolean alguemCom15anos = people
				.stream()
				.anyMatch(person -> person.getAge() == 15);
		System.out.println(
				String.format(
						"Alguém com 15 anos? Resposta: %s", 
						alguemCom15anos ? "Sim" : "Não"
							)
				);
		System.out.println("\n------------------------------\n");
		
		people
			.stream()
			.flatMap(person-> Stream.of(new PersonDTO(person.getName(), person.getAge())))
			.forEach(System.out::println);
	}
	
	public static List<Person> getPeople() {
		return List.of(
				new Person("Gloria Maria", "Feminina", 2),
				new Person("Joao", "Masculino", 15),
				new Person("Hanna", "Feminina", 13),
				new Person("Ruan", "Masculino", 12),
				new Person("Luiza", "Feminina", 13),
				new Person("Felix", "Feminina", 14),
				new Person("Pardim", "Masculino", 14),
				new Person("Leticia", "Feminina", 15),
				new Person("Thayná", "Feminina", 15),
				new Person("João Victor", "Masculino", 16),
				new Person("Gerônimo", "Masculino", 20),
				new Person("Maria Antunieta", "Feminina", 25)
				);
	}

}

class PersonDTO {
	private String name;
	private int age;
	
	public PersonDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return String.format("{ Name: %s, Age: %d }", name, age);
	}
}

class Person {
	private String name;
	private String gender;
	private int age;
	
	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return String.format("{ Name: %s, Gender: %s, Age: %d }", name, gender, age);
	}
}