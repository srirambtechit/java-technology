package com.msrm.tricky;

import java.util.HashSet;
import java.util.Set;

public class Tricky9 {

    public static void main(String[] args) {
	Set<String> set1 = new HashSet<String>();
	set1.add("One");
	set1.add("Two");

	System.out.println(set1);

	
	// Created anonymous class 
	Set<String> set2 = new HashSet<String>() {{
	    add("One");
	    add("Two");
	}};
	System.out.println(set2);
    }
}
