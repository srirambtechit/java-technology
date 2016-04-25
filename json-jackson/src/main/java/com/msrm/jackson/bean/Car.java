package com.msrm.jackson.bean;

public class Car {

	private String brand;

	private int doors;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", doors=" + doors + "]";
	}

}
