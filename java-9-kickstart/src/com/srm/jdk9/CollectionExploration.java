package com.srm.jdk9;

import java.util.List;
import java.util.ArrayList;

public class CollectionExploration {

	public static void main(String[] args) {
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
