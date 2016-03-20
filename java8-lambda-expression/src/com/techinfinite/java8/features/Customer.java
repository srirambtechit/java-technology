package com.techinfinite.java8.features;

public enum Customer {
    Google(1), Amazon(2), Microsoft(3), Oracle(4);

    private int id;

    Customer(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }

    public static Customer byId(int id) {
	return values()[id];
    }

    public static void main(String[] args) {
	Customer[] values = values();
	for (Customer customer : values) {
	    System.out.println(customer);
	}

    }
}