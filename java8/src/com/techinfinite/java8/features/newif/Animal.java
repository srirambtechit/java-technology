package com.techinfinite.java8.features.newif;

public interface Animal {

    default void walk() {
	System.out.println("Animal#Walking");
    }

}
