package com.msrm.lambda.usecases;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
		
		System.out.println("\nSort by age");
		Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
		Arrays.sort(rosterAsArray, Person::compareByAge);
		Stream.of(rosterAsArray)
		      .forEach(System.out::println);
	}
	//@formatter:on

}
