package com.msrm.lambda.usecases;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.msrm.lambda.pojo.Person;
import com.msrm.lambda.pojo.Person.Sex;

public class PersonLambda {

	//@formatter:off
	public static void main(String[] args) {
		List<Person> roster = Person.createRoster();
		for (Person person : roster) {
			System.out.println(person);
		}

		System.out.println();
		// lambda style
		roster.forEach(p -> System.out.println(p.getName()));

		System.out.println("\nDisplay all Male members");
		roster.stream()
			  .filter(p -> p.getGender() == Person.Sex.MALE)
		      .forEach(p -> System.out.println(p.getName()));
		
		System.out.println("\nAvg age of all Male members");
		Double average = roster.stream()
		      .filter(p->p.getGender() == Person.Sex.MALE)
		      .mapToInt(Person::getAge)
		      .average()
		      .getAsDouble();
		System.out.println(average);
		
		System.out.println("\nGroup members based on Sex");
		Map<Sex, List<Person>> gender = roster.stream()
			  .collect(Collectors.groupingBy(Person::getGender));
		System.out.println(gender);
		
		kindOfMethodRef();
	}

	
	static class ComparisonProvider {
	    public int compareByName(Person a, Person b) {
	        return a.getName().compareTo(b.getName());
	    }
	        
	    public int compareByAge(Person a, Person b) {
	        return a.getBirthday().compareTo(b.getBirthday());
	    }
	}
	
	public static void kindOfMethodRef() {
		List<Person> roster = Person.createRoster();
		
		//1. Reference to a static method
		System.out.println("\nSort by age");
		Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
		Arrays.sort(rosterAsArray, Person::compareByAge); // compareByAge is static method in Person
		Stream.of(rosterAsArray)
		      .forEach(System.out::println);
		
		//2. Reference to an instance method of a particular object
		System.out.println("\nSort by name");
		ComparisonProvider cp = new ComparisonProvider();
		Arrays.sort(rosterAsArray, cp::compareByName);
		Stream.of(rosterAsArray)
	      .forEach(System.out::println);
	
		//3. Reference to an instance method of an arbitrary object of a particular type
		System.out.println("\nSort array of strings");
		String[] stringArray = { "Barbara", "James", "Mary", "John",
			    "Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		Stream.of(stringArray)
		      .forEach(System.out::println);
		
		//4. Reference to a constructor
		System.out.println("\nReference to a constructor");
		HashSet<Person> personSet = transferElements(roster, () -> new HashSet<Person>());
		personSet.forEach(System.out::println);
		//or
		HashSet<Person> personSet2 = transferElements(roster, HashSet::new);
		System.out.println(personSet2);
	}
	
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST 
			transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
		DEST dest = collectionFactory.get();
		for (T t : sourceCollection) {
			dest.add(t);
		}
		return dest;
	}

}
