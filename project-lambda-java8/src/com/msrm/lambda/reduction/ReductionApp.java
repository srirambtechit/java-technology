package com.msrm.lambda.reduction;

import java.util.List;

//@formatter:off
public class ReductionApp {

	public static void main(String[] args) {
		List<NewPerson> persons = NewPerson.persons;

		// determine the oldest person
		persons.stream()
			.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
			.ifPresent(System.out::println);

		System.out.println();
		
		// construct a new Person with the aggregated names and 
		// ages from all other persons in the stream:
		NewPerson newPerson = persons.stream()
				.reduce(new NewPerson("", 0), (result, current) -> {
					result.name += current.name;
					result.age += current.age;
					return result;
				});
		System.out.printf("name=%s age=%d%n", newPerson.name, newPerson.age);
		
		System.out.println();
		
		// sum of age of all persons
		Integer summedAge = persons.stream()
			.reduce(0, (sum, person) -> sum += person.age, (sum1, sum2) -> sum1 + sum2);
		System.out.println("Sum of age : " + summedAge);
		
		System.out.println();
		
		// expand the above piece of code
		Integer summedAgeAgain = persons.parallelStream()
				.reduce(0, 
					(sum, person) -> {
						System.out.printf("accumulator : name=%s age=%d sum=%d%n", person.name, person.age, sum);
						return sum += person.age;
					}, 
					(sum1, sum2) -> {
						System.out.printf("combiner    : sum1=%d sum2=%d%n", sum1, sum2);
						return sum1 + sum2;
					});
			System.out.println("Sum of age : " + summedAgeAgain);
			
		
	}

}
