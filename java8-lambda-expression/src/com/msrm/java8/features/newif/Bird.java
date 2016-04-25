package com.msrm.java8.features.newif;

public interface Bird {

    default void walk() {
	System.out.println("Bird#Walking");
    }

}
