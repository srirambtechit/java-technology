package com.msrm.java8.features;

import java.io.File;
import java.io.FileFilter;

public class BasicLambda {

    public static void main(String[] args) {
	// () -> {} is can be assigned to type of FunctionalInterface (FI)
	// variable
	// since Runnable is FI, it is lambda expression
	Runnable r = () -> System.out.println("Lambda running");
	new Thread(r).start();

	// since FileFilter is lambda expression
	FileFilter ff = (File f) -> f.getName().endsWith(".xml");
	System.out.println(ff);

    }

}
