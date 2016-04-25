package com.msrm.java8.features.newif;

import java.util.Optional;

/**
 * jdk8 supports default methods in interface which is nothing but takes
 * implementation in interface. it leads to diamond problem like in C++ during
 * inheritance (from one interface to another). class should implement that
 * method to avoid diamond problem otherwise compiler throws an error like
 * 
 * <b>java: class NewSpecies inherits unrelated defaults for walk() from types
 * Animal and Bird</b>
 * 
 * @author sriram
 *
 */
public class NewSpecies implements Animal, Bird {

    // if you comment this method, compiler throws error
    // since Animal and Bird both has same default method called walk()
    public void walk() {
	System.out.println("NewSpecies");
    }

    public static void main(String[] args) {
	System.out.println("Ans : " + name("Mr.Sriram"));
	System.out.println("Ans : " + name("Ms.Palmer"));
    }

    public static String name(String str) {
	return Optional.ofNullable(str).filter(s -> s.startsWith("Mr")).map(s -> {
	    String[] arr = s.split("\\.");
	    return arr.length == 2 ? arr[1] : "";
	}).orElse("Dono");
    }

}
