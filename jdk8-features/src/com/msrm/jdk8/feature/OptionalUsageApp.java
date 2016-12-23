package com.msrm.jdk8.feature;

import java.util.Optional;

public class OptionalUsageApp {

	public static void main(String[] args) {
		// Optionals are not functional interfaces, instead it's a nifty utility
		// to prevent NullPointerException.Optional is a simple container for a
		// value which may be null or non-null. Think of a method which may
		// return a non-null result but sometimes return nothing. Instead of
		// returning null you return an Optional in Java 8
		Optional<String> op = Optional.of("foo");

		op.get(); // "foo"
		op.isPresent(); // true
		op.ifPresent(System.out::println);
		
		Optional<String> notOpt = Optional.empty();
		String orElse = notOpt.orElse("not there");
		System.out.println("orElse: " + orElse);

	}

}
