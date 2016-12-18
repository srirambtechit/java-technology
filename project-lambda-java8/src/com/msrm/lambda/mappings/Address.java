package com.msrm.lambda.mappings;

public class Address {
	int doorNumber;
	City city;

	public Address(int doorNumber, City city) {
		super();
		this.doorNumber = doorNumber;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", city=" + city + "]";
	}

}
