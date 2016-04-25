package com.msrm.java8.features;

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
	Collections.sort(invoices, new Comparator<Invoice>() {
	    @Override
	    public int compare(Invoice o1, Invoice o2) {
		return Double.compare(o1.getAmount(), o2.getAmount());
	    }
	});
	InvoiceDB.print(invoices);

	System.out.println("\n");

	// 2. new lambda style of coding- uncomment below comment style.1 code
	// invoices.sort(Comparator.comparingDouble(Invoice::getAmount));
	// InvoiceDB.print(invoices);
    }

}
