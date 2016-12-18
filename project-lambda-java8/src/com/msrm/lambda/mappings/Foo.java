package com.msrm.lambda.mappings;

import java.util.List;

public class Foo {
	String name;
	List<Bar> bars;

	Foo(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Foo [name=" + name + ", bars=" + bars + "]";
	}

}
