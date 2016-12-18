package com.msrm.lambda.mappings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//@formatter:off
public class FlatMapDemoApp {

	public static void main(String[] args) {
		Stream.generate(UUID::randomUUID)
			.limit(10)
			.map(uuid -> uuid.toString())
			.collect(Collectors.toCollection(LinkedList::new))
			.forEach(System.out::println);

		List<Foo> foos = IntStream.rangeClosed(1, 5)
			.mapToObj(i -> new Foo("foo" + i))
			.collect(Collectors.toList());
		System.out.println(foos);
		foos.stream()
			.forEach(foo -> {
				foo.bars = IntStream.range(0, 3)
					.mapToObj(i -> new Bar("bar" + i))
					.collect(Collectors.toList());
			});
		System.out.println(foos);
		
		// another approach
		List<Foo> anotherFoo = new ArrayList<>();
		IntStream.rangeClosed(1, 5)
			.mapToObj(i -> anotherFoo.add(new Foo("foo" + i)));
		anotherFoo.stream()
			.forEach(f -> {
				f.bars = IntStream.rangeClosed(1, 3)
					.mapToObj(i -> new Bar("bar" + i + " <- " + f.name))
					.collect(Collectors.toList());
			});
		
		anotherFoo.forEach(f -> {
			f.bars.forEach(b -> System.out.println(b.name));
		});
		
		// another approach
		IntStream.rangeClosed(1, 5)
			.mapToObj(i -> new Foo("foo" + i))
			.peek(f -> {
				f.bars = IntStream.rangeClosed(1, 3)
							.mapToObj(i -> new Bar("bar" + i + " <- " + f.name))
							.collect(Collectors.toList());
			})
			.flatMap(f -> f.bars.stream())
			.forEach(b->System.out.println(b.name));
	}

}
