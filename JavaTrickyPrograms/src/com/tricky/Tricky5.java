package com.tricky;

public class Tricky5 {

    public int foo(int i) {
	return i < 10 ? null : i;
    }

    public static void main(String[] args) {
	Tricky5 t = new Tricky5();
	System.out.println(t.foo(49));

	// below line throws NPE
	System.out.println(t.foo(2));
    }

}
