package com.msrm.tricky;

public class Tricky3 {

    // Below line leads StackOverflowError,
    // so no object creation for the same class
    Tricky3 tricky3 = new Tricky3();

    public static void main(String[] args) {
	new Tricky3();
    }

}
