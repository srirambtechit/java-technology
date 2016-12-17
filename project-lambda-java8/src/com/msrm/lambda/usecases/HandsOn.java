package com.msrm.lambda.usecases;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.msrm.lambda.pojo.Person;

public class HandsOn {

	public static void main(String[] args) {
		IntStream.range(1, 11).forEach(System.out::println);

		System.out.println();

		Map<Integer, Integer> map = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.collect(Collectors.toMap(i -> i, i -> i * 10 + 1));
		System.out.println(map);

		Stream.<String>builder().add("abc").add("def").build().forEach(System.out::println);

		System.out.println();

		Stream.generate(() -> "abc").limit(5).forEach(System.out::println);

		System.out.println();

		Stream.iterate(1, n -> n * 2).limit(10).forEach(System.out::println);

		System.out.println("\n2 Table");
		IntStream.range(1, 11).map(i -> i * 2).forEach(System.out::println);

		Stream<Integer> stream = Stream.iterate(1, i -> i + 1).limit(10);
		// stream.forEach(i -> System.out.printf("%d ", i));
		System.out.println();

		Optional<Integer> findAny = stream.findAny();
		if (findAny.isPresent()) {
			System.out.println("findAny : " + findAny.get());
		}

		// stream closed, below code throws IllgealStateException
		// Optional<Integer> findFirst = stream.findFirst();
		// System.out.println("findFirst : " + findFirst);

		Collectors.toList();

		System.out.println();
		List<Person> persons = Person.createRoster();
		Supplier<StringJoiner> supplier = () -> {
			StringJoiner j = new StringJoiner(" | ");
			System.out.println("supplier : " + j.hashCode());
			return j;
		};
		BiConsumer<StringJoiner, Person> accumulator = (j, p) -> {
			System.out.printf("accumulator : %s %s%n", j, p);
			j.add(p.getName());
		};
		// combiner runs only when parallelStream executes
		BinaryOperator<StringJoiner> combiner = (j1, j2) -> {
			System.out.printf("combiner : %s %s%n", j1.toString(), j2.toString());
			return j1.merge(j2);
		};
		Function<StringJoiner, String> finisher = j -> {
			System.out.printf("finisher : %s%n", j);
			return j.toString();
		};
		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(supplier,
				accumulator, combiner, finisher);

		String names = persons.parallelStream().collect(personNameCollector);

		System.out.println(names);

		System.out.println();

		// Infinite hashSet objects created
		// Stream.generate(HashSet::new)
		// .forEach(System.out::println);

		List<String> elements = Stream.of("a", "b", "c").filter(element -> element.contains("b"))
				.collect(Collectors.toList());
		Optional<String> anyElement = elements.stream().findAny();
		Optional<String> firstElement = elements.stream().findFirst();
		System.out.println(anyElement);
		System.out.println(firstElement);

		System.out.println();

		BiPredicate<String, Integer> biCheck = (a, b) -> a.endsWith("lo") && b == 3;
		biCheck.test("hello", 3);

		System.out.println();

		// reduction, combiner getting executed only when stream is PARALLEL
		// mode
		Integer value = Arrays.asList(1, 2, 3, 4, 5).parallelStream().reduce(10, (a, b) -> {
			System.out.printf("accumulator : a=%d b=%d sum=%d%n", a, b, a + b);
			return a + b;
		}, (a, b) -> {
			System.out.printf("combiner : a=%d b=%d sum=%d%n", a, b, a + b);
			return a + b;
		});
		System.out.println("Reduced value : " + value);

		System.out.println();

		// Custom Collector object creation
		Collector<Person, ?, LinkedList<Person>> linkedPersonList = Collector.of(LinkedList::new,
				LinkedList::add, (first, second) -> {
					System.out.println("comiber");
					first.addAll(second);
					return first;
				});
		LinkedList<Person> linkedList = persons.stream()
			.collect(linkedPersonList);
		System.out.println(linkedList);
		
		System.out.println();
	}

	public static Stream<Integer> streamOf(List<Integer> list) {
		return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}

}
