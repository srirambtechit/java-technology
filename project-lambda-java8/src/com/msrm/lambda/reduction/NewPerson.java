package com.msrm.lambda.reduction;

import java.util.Arrays;
import java.util.List;

public class NewPerson {
	String name;
	int age;

	NewPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

	@Override
	public String toString() {
		return name;
	}
	
	public static List<NewPerson> persons =
		    Arrays.asList(
		        new NewPerson("Max", 18),
		        new NewPerson("Peter", 23),
		        new NewPerson("Pamela", 23),
		        new NewPerson("David", 12));
}
