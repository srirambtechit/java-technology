package com.zeitgest.java8.features;

public class Invoice {

    private int id;
    private double amount;

    public Invoice(int id, double amount) {
	super();
	this.id = id;
	this.amount = amount;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    @Override
    public String toString() {
	return "Invoice [id=" + id + ", amount=" + amount + "]";
    }

}
