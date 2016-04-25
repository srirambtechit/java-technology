package com.msrm.tricky;

public class PassByValue {

    public static void main(String[] args) {
	int x = 50;
	String s = "xyz";

	stringChange(s);
	intChange(x);

	System.out.println("x = " + x);
	System.out.println("s = " + s);
    }

    static void stringChange(String s1) {
	s1 = "abc";
    }

    static void intChange(int x1) {
	x1 = 100;
    }

}
