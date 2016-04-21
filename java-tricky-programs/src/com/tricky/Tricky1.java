package com.tricky;

class T {

    // if keyword "final" removed, output differs
    // Bcoz, compiler optimize the code
    public static final int x = 100;

    static {
	System.out.println("T loaded");
    }
}

public class Tricky1 {

    public static void main(String[] args) {

	System.out.println(T.x);

    }

}
