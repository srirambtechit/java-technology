package com.msrm.jdk8.feature;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.msrm.jdk8.feature.helper.Person;

public class BuildInFunctionalInterface {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// ------------------------------
		// 1. Predicate
		// Predicates are boolean-valued functions of one argument. The
		// interface contains various default methods for composing predicates
		// to complex logical terms (and, or, negate)
		Predicate<Integer> counter = (num) -> num > 0;
		counter.test(5); // true
		counter.negate().test(5); // false

		Integer nullInteger = null;
		Predicate<Integer> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		boolean test = nonNull.test(nullInteger);
		System.out.println(test);

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		// ------------------------------
		// 2. Function
		// Functions accept one argument and produce a result. Default methods
		// can be used to chain multiple functions together (compose, andThen).
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		String stringBack = backToString.apply("123");
		System.out.println(stringBack);
		// ------------------------------
		// 3. Supplier
		// Suppliers produce a result of a given generic type. Unlike Functions,
		// Suppliers don't accept arguments.
		Supplier<Person> personSupplier = Person::new;
		Person person = personSupplier.get();
		// ------------------------------
		// 4. Consumer
		// Consumers represents operations to be performed on a single input
		// argument.
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
		// ------------------------------
		// Supplementary functional interfaces
		// 5. BinaryOperator
		BinaryOperator<Integer> adder = (a, b) -> a + b;
		Integer result = adder.apply(4, 5);
		System.out.println("binary: " + result);
		// ------------------------------
		// 6. UnaryOpertor
		UnaryOperator<Integer> checker = (i) -> i + 2;
		System.out.println("unary: " + checker.apply(4));
		// ------------------------------
		// 7. Comparator
		// Comparators are well known from older versions of Java. Java 8 adds
		// various default methods to the interface.
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0
		// ------------------------------
	}

}
