package com.techinfinite.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvoiceDB {

    public static List<Invoice> allInvoice() {
	List<Invoice> list = new ArrayList<>();
	Random r = new Random(4);

	for (int i = 1; i <= 25; i++) {
	    double amount = Math.random() * 10_000;
	    Invoice inv = new Invoice(i, (Math.round(amount * 100.0) / 100.0));
	    int custId = r.nextInt(4);
	    inv.setCustomer(Customer.byId(custId));
	    list.add(inv);
	}
	return list;
    }

    public static void print(List<Invoice> invoices) {
	StringBuffer format = new StringBuffer();
	format.append("%3d"); // for invoice id
	format.append("%10s");// for extra space
	format.append("%.2f");// for invoice amount
	format.append("%10s");// for extra space
	format.append("%s");// for invoice customer
	format.append("%n");// for new line

	String space = "";
	System.out.println("Invoice list");
	System.out.printf("%s%10s%s%10s%s%n", " ID", space, " Amount", space, " Customer");
	for (Invoice invoice : invoices) {
	    System.out.printf(format.toString(), invoice.getId(), space, invoice.getAmount(), space, invoice.getCustomer());
	}
    }

}
