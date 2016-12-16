import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamManipulation {
	
	public static void main(String []args) {
		// find numbers greater than 10
		Stream.of(23, 19, 2, 8, 92, 10, 10, 11, 93, 5, 3)
			.filter(i -> i > 10)
			.forEach(i -> System.out.print(i + ", "));
		
		System.out.println();

		// generate numbers from 1 to 9
		IntStream.range(1, 10)
			.forEach(i -> System.out.print(i + ", "));

		System.out.println();

		// generate costMap of key k such that 1 <= k <= 10 with value of k * 10 + 1
		Map<Integer, Integer> costMap = IntStream.range(1, 11)
			.collect(Collectors.toMap(i -> i, i -> i * 10 + 1));
		System.out.println("Cost Map \n " + costMap);
	}

}
