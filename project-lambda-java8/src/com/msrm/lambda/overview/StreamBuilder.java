package com.msrm.lambda.overview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//@formatter:off
public class StreamBuilder {

	public static void main(String []args) {
		// stream by Integer objects
		Stream.of(23, 12, 89, 23, 43, 92, 2, 19, 89, 25, 17, 19)
			  .forEach(i -> System.out.print(i + ", "));

		System.out.println();

		// stream by array of Integer
		Stream.of(new Integer[] { 1, 3, 8, 3, 4, 9, 10, 6, 7, 5 })
			  .forEach(i -> System.out.format("%d, ", i));

		System.out.println();

		// stream by array of primitive ints
		Arrays.stream(new int[] { 3, 4, 8, 1, 2, 9, 5 } )
				.forEach(i -> {
					System.out.print(i + ", "); 
				});

		// string to ints
		IntStream chars = "sriram".chars();

		// converting into collection like List<Integer>
		List<Object> nums = chars.collect(ArrayList::new, 
				(list, i) -> list.add(i), 
				(r1, r2) -> {});
		System.out.println(nums);

		System.out.println();

		List<Integer> list = Arrays.asList(3, 8, 9, 6, 4, 5);

		// sequential stream
		Stream<Integer> seqStream = list.stream(); 
		System.out.println(seqStream);

		// parallel stream
		Stream<Integer> parallelStream = list.parallelStream(); 
		System.out.println(parallelStream);
	
	}

}
