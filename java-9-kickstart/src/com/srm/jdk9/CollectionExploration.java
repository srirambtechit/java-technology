package com.srm.jdk9;

import java.util.List;
import java.util.Set;
import java.util.Map;
import static java.util.Map.*;
import java.util.ArrayList;

/**
 * It is JDK 9 EA version's of Collection API enhancements
 * 
 * @author sriram
 *
 */
public class CollectionExploration {

	public static void main(String[] args) {
		// jdk9List();
		// jdk9Set();
		jdk9Map();
	}

	public static void jdk9Map() {
		// Empty immutable map & if you insert UnsupportedOperationException
		Map<String, Integer> emptyMap = Map.of();
		emptyMap.put("height", 174);

		// It can take upto 10 elements to Map
		Map<String, Integer> heights = Map.of("sriram", 174, "prabhu", 158, "surya", 188, "praveen", 159);
		System.out.println(heights);

		// To add more than 10 objects to Map
		Map<String, String> cities = Map.ofEntries(
				Map.entry("sriram", "madurai"), 
				entry("prabhu", "madurai"),
				entry("jack", "london"),
				entry("shankar", "coimbator")
				);
		System.out.println(cities);
	}

	public static void jdk9Set() {
		Set<Integer> emptySet = Set.of();
		System.out.println(emptySet);

		// Below code throws an IllegalArgumentException: duplicate element of 4
		Set<Integer> numSet = Set.<Integer>of(3, 2, 1, 4, 8, 9, 17, 5, 0, 6, 4, 14, 18, 39);
		System.out.println(numSet);

		// Throws NPE
		Set.of(1, null);
	}

	public static void jdk9List() {
		List<Integer> numList = List.of(1, 2, 3, 4);
		System.out.println(numList);

		List<String> strList = List.of("abc", "def", "ghi", "jkl", "mno");
		System.out.println(strList);

		List<Integer> emptyList = List.of();
		System.out.println(emptyList);
		emptyList.add(33);
		System.out.println(emptyList);

		// Old collection API allows null to it
		List<String> arr = new ArrayList<>();
		arr.add("sriram");
		arr.add(null);
		System.out.println(arr);

		// from JDK 8 APIs, won't allow null as value
		List<Integer> nullList = List.of(2, 1, null);
		System.out.println(nullList);
	}

}
