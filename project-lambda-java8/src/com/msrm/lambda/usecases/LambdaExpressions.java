package com.msrm.lambda.usecases;

import java.util.Comparator;

public class LambdaExpressions {

	interface Operation<T> {
		public T perform(T t1, T t2);
	}

	public static void main(String[] args) {
		// Lambda expression - () -> { }
		Operation<Integer> add = (Integer a, Integer b) -> {
			return a + b;
		};
		System.out.println("Add : " + add.perform(3, 4));

		// Lambda expression - Automatically type inferred
		Operation<Integer> sub = (a, b) -> {
			return a - b;
		};
		System.out.println("Sub : " + sub.perform(3, 4));

		// Lambda expression - if one statement no need of { }
		Operation<Integer> mul = (a, b) -> a * b;
		System.out.println("Mul : " + mul.perform(3, 4));

		// Lambda expression - Thread spawing
		Runnable r = () -> System.out.println("Hello");
		new Thread(r).start();

		// Method references
		Comparable<String> cmpbl = String::length;

		Comparator<String> cmptr = (a, b) -> a.toUpperCase().compareTo(b.toLowerCase());
				
	}

}
