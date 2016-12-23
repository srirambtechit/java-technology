package com.msrm.jdk8.feature;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaScopesApp {

	// irrespective of local variables, instance and static variables
	// can be accessed from lambda
	int instanceVariable = 100;
	static int staticVariable = 200;

	public static void main(String[] args) {
		// 1. accessing local variables
		int localVariable = 300;
		// error below 2 lines of code deals with localVariable
		// localVariable is used in lambda as well as assigned value as 6
		// since localVariable variable scope is effectively final in
		// lambda expression
		Predicate<Integer> test = (i) -> i + localVariable > 10;
		System.out.println("preidcate: " + test.test(8));
		// if below line uncommented, will get compile-time error
		// localVariable = 6;

		System.out.println("num = " + localVariable);

		Consumer<Integer> localVariablePrint = number -> System.out
				.println("consumer: " + (localVariable + number));
		localVariablePrint.accept(5);

		// 2. accessing instance variables
		LambdaScopesApp app = new LambdaScopesApp();
		Consumer<Integer> instanceVariablePrint = number -> System.out
				.println("instanceVariablePrint: " + (app.instanceVariable + number));
		instanceVariablePrint.accept(5);

		// 3. accessing static variables
		Consumer<Integer> staticVariablePrint = number -> System.out
				.println("staticVariablePrint: " + (staticVariable + number));
		staticVariablePrint.accept(5);

		// 4. accessing interface default methods, compile-time error
		Formula formula1 = (n) -> sqrt(n);
		
		// 5. without Lambda interface name, can't access static method
		// from FunctionalInterface
		Formula formula2 = (n) -> Formula.staticSqrt(n);
	}

}
