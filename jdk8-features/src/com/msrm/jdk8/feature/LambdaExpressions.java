package com.msrm.jdk8.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("xavier", "martin", "ziaur", "shran", "helen", "bob",
				"chelle", "michale");
		System.out.println(names);

		// JDK-8 prior
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		System.out.println(names);

		// JDK-8 onwards
		Collections.sort(names, (String s1, String s2) -> {
			return s1.compareTo(s2);
		});

		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

}
