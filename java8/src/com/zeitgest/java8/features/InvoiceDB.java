package com.zeitgest.java8.features;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDB {

    public static List<Invoice> allInvoice() {
	List<Invoice> list = new ArrayList<>();
	for (int i = 1; i <= 25; i++) {
	    double amount = Math.random() * 10_000;
	    Invoice inv = new Invoice(i, (Math.round(amount * 100.0) / 100.0));
	    list.add(inv);
	}
	return list;
    }

    public static void print(List<Invoice> invoices) {
	System.out.println("Invoice list");
	System.out.printf("%3s\t%s%n", "ID", "Amount");
	for (Invoice invoice : invoices) {
	    System.out.printf("%3d\t%.2f%n", invoice.getId(), invoice.getAmount());
	}
    }

}
