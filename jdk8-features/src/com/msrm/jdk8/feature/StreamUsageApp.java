package com.msrm.jdk8.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsageApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("ddd2");
		strings.add("aaa2");
		strings.add("bbb1");
		strings.add("aaa1");
		strings.add("bbb3");
		strings.add("ccc");
		strings.add("bbb2");
		strings.add("ddd1");

		// ------------------------------
		// 1. sequential stream
		// converting into stream, useful for single threaded environment
		Stream<String> seqStream = strings.stream();
		// ------------------------------
		// 2. parallelStream
		// converting into parallelStream for parallel processing, useful for
		// multi-threaded environment
		Stream<String> parallelStream = strings.parallelStream();
		// ------------------------------
		// Two type of operation, intermediate and terminal operations
		// 3. filter - intermediate
		// filter some data
		strings.stream().filter(s -> s.endsWith("1"));
		// ------------------------------
		// 4. sorted - intermediate
		// sort list of data
		strings.stream().sorted();
		strings.stream().sorted((s1, s2) -> s1.compareTo(s2));
		Arrays.asList(23.32, 64.6, 89.34, 13.54, 73.42, 91.43, 10.234).stream().sorted();
		// ------------------------------
		// 5. map - intermediate
		// convert elements into other form
		strings.stream().map((s) -> s.toUpperCase());
		// ------------------------------
		// 6. Matching operation - terminal
		boolean anyMatch = strings.stream().anyMatch(s -> s.startsWith("a"));
		boolean allMatch = strings.stream().allMatch(s -> s.startsWith("a"));
		boolean noneMatch = strings.stream().noneMatch(s -> s.startsWith("a"));
		Optional<String> findAny = strings.stream().findAny();
		Optional<String> findFirst = strings.stream().findFirst();

		System.out.println("anyMatch: " + anyMatch);
		System.out.println("allMatch: " + allMatch);
		System.out.println("noneMatch: " + noneMatch);
		findAny.ifPresent(System.out::println);
		String result = findFirst.orElse("Empty bag");
		System.out.println("findFirst: " + result);
		// ------------------------------
		// 7. count - terminal
		// count number of elements in stream
		long count = strings.stream().count();
		// ------------------------------
		// 8. reduce - terminal
		// This terminal operation performs a reduction on the elements of the
		// stream with the given function. The result is an Optional holding the
		// reduced value.
		// joining all strings into single string of text
		strings.stream().reduce((a, b) -> a + "#" + b).ifPresent(System.out::println);
		int totalLength = strings.stream().reduce(0, (a, b) -> a + b.length(), (r, a) -> r + a);
		System.out.println("Total string length: " + totalLength);
		// ------------------------------
		// 9. collect - terminal
		// converting strings to upper case string and get it in Arrays
		Set<String> uniqueUpperCaseStrings = strings.stream().map(String::toUpperCase)
				.collect(Collectors.toCollection(HashSet::new));
		System.out.println("Unique upperCaseStrings : " + uniqueUpperCaseStrings);

		// ------------------------------
		// PARALLEL STREAM
		// ------------------------------
		// Performance measurements
		List<String> uniqStrings = new ArrayList<>();
		int max = 1000_000; // 1 million records
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			uniqStrings.add(uuid.toString());
		}
		
		long t0, t1, uniqStrSeqCount;
		long timeTaken;
		t0 = System.nanoTime();
		uniqStrSeqCount = uniqStrings.stream().sorted().count();
		t1 = System.nanoTime();
		timeTaken = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.printf("%n%d elements sorted in %d sec.%n", uniqStrSeqCount, timeTaken);
		
		t0 = System.nanoTime();
		uniqStrSeqCount = uniqStrings.parallelStream().sorted().count();
		t1 = System.nanoTime();
		timeTaken = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.printf("%n%d elements sorted in %d sec.%n", uniqStrSeqCount, timeTaken);
		// ------------------------------
	}

}
