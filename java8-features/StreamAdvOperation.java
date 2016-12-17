import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamAdvOperation {
	
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
        	new Person("Max", 18),
        	new Person("Peter", 23),
        	new Person("Pamela", 23),
        	new Person("David", 12));	

		System.out.println();

		// list person name startsWith P
		List<String> names = persons.stream()
			.filter(p -> p.name.startsWith("P"))
			.map(p -> p.name)
			.collect(Collectors.toList());
		System.out.println(names);

		System.out.println();

		// group persons by age
		Map<Integer, List<Person>> personsByAge = persons.stream()
			.collect(Collectors.groupingBy(p -> p.age));
		System.out.println(personsByAge);

		System.out.println();

		personsByAge
			.forEach((age, person) -> System.out.println(age + " : " + person));
		
		System.out.println();
		
		// average of all person's age
		persons.stream()
			.mapToInt(p -> p.age)
			.average()
			.ifPresent(r -> System.out.println("avg : " + r));

		System.out.println();

		// summarizing computation
		IntSummaryStatistics ageSummary = persons.stream()
			.collect(Collectors.summarizingInt(p -> p.age));
		System.out.println(ageSummary);
		
		System.out.println();

		// join all person details as one string
		String text = persons.stream()
			.filter(p -> p.age >= 18)
			.map(p -> p.name)
			.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		System.out.println(text);

		System.out.println();

		// join person names based on age
		Map<Integer, String> namesByAge = persons.stream()
			.collect(Collectors.toMap(
			p -> p.age,
			p -> p.name,
			(name1, name2) -> name1 + ";" + name2));
		System.out.println(namesByAge);

		System.out.println();
		
		// person names former
		Supplier<StringJoiner> supplier = () -> new StringJoiner(" | ");
		BiConsumer<StringJoiner, Person> accumulator = (j, s) -> j.add(s.name);
		BinaryOperator<StringJoiner> combiner = (j1, j2) -> j1.merge(j2);
		Function<StringJoiner, String> finisher = j -> j.toString();
		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(supplier,
				accumulator, combiner, finisher);
		
		String nameString = persons.stream()
			.collect(personNameCollector);
		System.out.println(nameString);

		System.out.println();
	}

}
