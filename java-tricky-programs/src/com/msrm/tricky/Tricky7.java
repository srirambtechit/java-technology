package com.msrm.tricky;

public class Tricky7 {

    public static void main(String[] args) {

	// Throws NumberFormatException at runtime
	Integer i = new Integer(null);

	// Makes Compile time error
	// String s = new String(null);
    }

}
