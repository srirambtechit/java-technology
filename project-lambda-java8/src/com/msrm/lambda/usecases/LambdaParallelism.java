package com.msrm.lambda.usecases;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaParallelism {

	public static void main(String[] args) {
		Integer[] ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> intList = Arrays.asList(ints);
		System.out.println(intList);

		System.out.println("Stream data");
		intList.stream().forEach(n -> System.out.print(n + " "));

		System.out.println("\nParallelstream data");
		intList.parallelStream().forEach(n -> System.out.print(n + " "));

		System.out.println("\nAnother parallelstream data");
		intList.parallelStream().forEach(n -> System.out.print(n + " "));

		System.out.println("\nParallelstream ordered data");
		intList.parallelStream().forEachOrdered(n -> System.out.print(n + " "));

		System.out.println("\nReversed list");
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reverse = normal.reversed();
		intList.sort(reverse);
		System.out.println(intList);
	}

}
