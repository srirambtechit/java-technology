package com.msrm.tricky;

public class FinallyPower {

    public static void main(String[] args) {
	System.out.println(returnSomething());
    }

    public static int returnSomething() {
	try {
	    throw new RuntimeException("foo");
	} finally {
	    return 0;
	}
    }

}
