package com.msrm.jdk8.feature.helper;

public interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}
