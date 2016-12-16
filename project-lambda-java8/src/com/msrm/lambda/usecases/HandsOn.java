package com.msrm.lambda.usecases;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HandsOn {

	public static void main(String[] args) {
		IntStream.range(1, 11).forEach(System.out::println);

		System.out.println();

		Map<Integer, Integer> map = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.collect(Collectors.toMap(i -> i, i -> i * 10 + 1));
		System.out.println(map);
		
		Stream.<String>builder().add("abc").add("def").build().forEach(System.out::println);
		
		System.out.println();
		
		Stream.generate(() -> "abc")
			.limit(5)
			.forEach(System.out::println);
		
		System.out.println();
		
		Stream.iterate(1, n -> n * 2)
			.limit(10)
			.forEach(System.out::println);
		
		System.out.println("\n2 Table");
		IntStream.range(1, 11)
			.map(i -> i * 2)
			.forEach(System.out::println);
		
		
		Stream<Integer> stream = Stream.iterate(1, i -> i + 1).limit(10);
//		stream.forEach(i -> System.out.printf("%d ", i));
		System.out.println();
		
		Optional<Integer> findAny = stream.findAny();
		if(findAny.isPresent()) {
			System.out.println("findAny : " + findAny.get());
		}
		
		// stream closed, below code throws IllgealStateException
//		Optional<Integer> findFirst = stream.findFirst();
//		System.out.println("findFirst : " + findFirst);
		
		System.out.println("A2".startsWith("a"));

	}

	public static Stream<Integer> streamOf(List<Integer> list) {
		return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}

}
