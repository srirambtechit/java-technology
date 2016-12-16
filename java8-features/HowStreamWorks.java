import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class HowStreamWorks {
	
	public static void main(String[] args) {
		List<String> myList =
		    Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream()
			.filter(s -> s.startsWith("c"))
			.sorted()
			.map(String::toUpperCase)
			.forEach(System.out::println);

		System.out.println();

		myList.stream()
			.findFirst()
			.ifPresent(System.out::println);

		System.out.println();

		Stream.of("a1", "a2", "a3", "a6", "a7", "a5")
			.map(s -> s.substring(1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(System.out::println);

		System.out.println();

		// primitive stream to object stream
		IntStream.range(1, 6)
			.mapToObj(i -> "a" + i)
			.forEach(s -> System.out.print(s + ", "));

		System.out.println();

		// double -> int -> object stream
		Stream.of(1.0, 3.0, 5.0, 2.0)
			.mapToInt(Double::intValue)
			.mapToObj(i -> "a" + i)
			.forEach(s -> System.out.print(s + ", "));

		System.out.println();

		// Stream processing order, no output as it doesn't have terminal operation
		Stream.of(3, 2, 1, 8)
			.filter(i -> {
				System.out.println(i);
				return true;
			});

		// Below code does
		Stream.of(3, 2, 1, 8)
			.filter(i -> {
				System.out.println("filtering : " + i);
				return true;
			})
			.forEach(i -> System.out.println("forEach : " + i));

		// stop processing stream once the terminal operation done
		// its work (here once anyMatch returns true, internal iteration stops
		Stream.of("d3", "a2", "b8", "c3")
			.map(s -> {
				System.out.println("filter : " + s);
				return s.toUpperCase();
			})
			.anyMatch(s -> {
				System.out.println("anyMatch : " + s);
				return s.startsWith("A");
			});

		System.out.println();

		// order is matters, 5 iteration for map and filter
		Stream.of("d2", "a2", "b1", "b3", "c")
			.map(s -> {
				System.out.println("map : " + s);
				return s.toUpperCase();
			})
			.filter(s -> {
				System.out.println("filter : " + s);
				return s.startsWith("A");
			})
			.forEach(s -> {
				System.out.println("forEach : " + s);
			});

		System.out.println();

		// greatly reduce number of execution if the order changed
		Stream.of("d2", "a2", "b1", "b3", "c")
			.filter(s -> {
				System.out.println("filter : " + s);
				return s.startsWith("a");
			})
			.map(s -> {
				System.out.println("map :" + s);
				return s.toUpperCase();
			})
			.forEach(s -> {
				System.out.println("forEach : " + s);
			});

		System.out.println();

		// sorting is another useful intermediate operation
		Stream.of("d2", "a2", "b1", "b3", "c")
			.sorted((a, b) -> {
				System.out.printf("sorted : %s, %s%n", a, b);
				return a.compareTo(b);
			})
			.filter(s -> {
				System.out.println("filter : " + s);
				return s.startsWith("a");
			})
			.map(s -> {
				System.out.println("map : " + s);
				return s.toUpperCase();
			})
			.forEach(s -> {
				System.out.println("forEach : " + s);
			});


		System.out.println();

		// above code optimzed
		Stream.of("d2", "a2", "b1", "b3", "c")
			.filter(s -> {
				System.out.println("filter : " + s);
				return s.startsWith("a");
			})
			.sorted((a, b) -> {
				System.out.printf("sorted : %s, %s%n", a, b);
				return a.compareTo(b);
			})
			.map(s -> {
				System.out.println("map : " + s);
				return s.toUpperCase();
			})
			.forEach(s -> {
				System.out.println("forEach : " + s);
			});

	}

}
