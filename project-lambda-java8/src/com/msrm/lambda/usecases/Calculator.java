package com.msrm.lambda.usecases;

public class Calculator {

	// only one abstract method so, it is FunctionalInterface
	interface BiOperation<T> {
		public T op(T a, T b);
	}

	public static void main(String[] args) {
		BiOperation<Integer> add = (a, b) -> a + b;
		BiOperation<Integer> sub = (a, b) -> a - b;
		BiOperation<Integer> mul = (a, b) -> a * b;
		BiOperation<Integer> div = (a, b) -> a / b;
		
		System.out.println("Addition: " + add.op(6, 2));
		System.out.println("Subtraction: " + sub.op(6, 2));
		System.out.println("Multiplication: " + mul.op(6, 2));
		System.out.println("Divison: " + div.op(6, 2));
	}
}
