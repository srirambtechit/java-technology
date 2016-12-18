package com.msrm.lambda.overview;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

		System.out.println("\n");

		// generate costMap of key k such that 1 <= k <= 10 with value of k * 10 + 1
		Map<Integer, Integer> costMap = IntStream.range(1, 11)
				.parallel()
				.collect(HashMap::new, (map, num) -> {
					map.put(num, num * 10 + 1);
					System.out.println("accumulator : " + map + " : " + num);
				}, (resultMap, currentMap) -> {
					resultMap.putAll(currentMap);
					System.out.println("combiner : " + resultMap + " : " + currentMap);
				});
		System.out.println(costMap);
	}

}
