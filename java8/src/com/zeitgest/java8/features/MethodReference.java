package com.zeitgest.java8.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {

	List<Invoice> invoices = InvoiceDB.allInvoice();
	InvoiceDB.print(invoices);

	// take invoices whose amount greater than 5000 and
	// sort that list based on amount
	System.out.println("\nInvoice amount greater than 5000");

	// 1. old way of coding
	List<Invoice> grt5000 = new ArrayList<>();
	for (Invoice invoice : invoices) {
	    if (invoice.getAmount() > 5000) {
		grt5000.add(invoice);
	    }
	}
	Collections.sort(grt5000, new Comparator<Invoice>() {
	    @Override
	    public int compare(Invoice o1, Invoice o2) {
		return Double.compare(o1.getAmount(), o2.getAmount());
	    }
	});
	InvoiceDB.print(grt5000);
    }

    // new lambda style of coding

}
