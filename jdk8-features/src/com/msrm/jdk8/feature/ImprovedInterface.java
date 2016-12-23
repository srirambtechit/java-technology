package com.msrm.jdk8.feature;

/**
 * <p>
 * 1. Native interface changes
 * <li>1. default methods
 * <li>2. static methods
 * <li>3. caller class force impl of when diamond problem occurs like in C++
 * <p>
 * 2. Functional interface
 * <li>only one abstract method, n number of default and static methods with
 * impl
 * 
 * @author srirammuthaiah
 *
 */
public class ImprovedInterface {

	public static void main(String[] args) {
		Formula f = new Formula() {
		
			public double calculate(int a) {
				// It is default method in Formula interface
				// it has scope to access from outside of interface like 
				// anonymous class
				return sqrt(a); 
			}
		};
		
		System.out.println("Sqrt(2) : " + f.calculate(2));
		System.out.println("Sqrt(2) : " + f.sqrt(2));
		
		Elephant el = new Elephant();
		el.move();
		el.defaultMethod();
//		el.staticMethod(); // not feasible
		
		Walkable walkEl = new Elephant();
		walkEl.defaultMethod();
		walkEl.move();
		//walkEl.staticMethod(); // not feasible
		Walkable.staticMethod();
	}

}

// Example: 1
interface Formula {
    double calculate(int a);
    
    static double staticSqrt(int a) {
    	return Math.sqrt(a);
    }

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

// Example: 2
interface Walkable {

	public void move();

	public static void staticMethod() {
		System.out.println("Walkable - staticMethod");
	}

	public default void defaultMethod() {
		System.out.println("Walkable - defaultMethod");
	}

}

interface Runnable {

	public void move();

	public static void staticMethod() {
		System.out.println("Runnable - staticMethod");
	}

	public default void defaultMethod() {
		System.out.println("Runnable - defaultMethod");
	}
}

interface FastWalkRunner extends Walkable, Runnable {

	public void run();

	// since, Runnable and Walkable interface having same method called
	// defaultMethod(), forcibly overridden in FastWalkRunner interface
	@Override
	default void defaultMethod() {
		Runnable.super.defaultMethod();
		System.out.println("FastWalkRunner - defaultMethod");
	}
}

class Elephant implements Walkable {

	@Override
	public void move() {
		System.out.println("I'm elephant walking...");
	}

}

class Tiger implements FastWalkRunner {
	@Override
	public void move() {
		System.out.println("I'm tiger moving...");
	}

	@Override
	public void run() {
		System.out.println("Im' tiger running...");
	}
}

