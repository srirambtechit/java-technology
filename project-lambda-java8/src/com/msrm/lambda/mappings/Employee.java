package com.msrm.lambda.mappings;

public class Employee {
	String name;
	Office office;

	public Employee(String name, Office office) {
		super();
		this.name = name;
		this.office = office;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", office=" + office + "]";
	}

}
