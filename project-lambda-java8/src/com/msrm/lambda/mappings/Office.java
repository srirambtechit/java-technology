package com.msrm.lambda.mappings;

public class Office {
	String name;
	Address address;

	public Office(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Office [name=" + name + ", address=" + address + "]";
	}

}
