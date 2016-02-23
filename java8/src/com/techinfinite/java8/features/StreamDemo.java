package com.techinfinite.java8.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * need to filter a list of invoices to find those
 * related to a specific customer whose invoice amount
 * is more than 5000, sort them by amount of the invoice,
 * and then extract their IDs. Using the Streams API
 * 
 * @author sriram
 *
 */
public class StreamDemo {

    public static void main(String[] args) {
	List<Invoice> invoices = InvoiceDB.allInvoice();
	InvoiceDB.print(invoices);

	List<Integer> ids = findInvoiceOld(invoices, Customer.Oracle);
	System.out.println(ids);

	ids = findInvoiceNew(invoices, Customer.Oracle);
	System.out.println(ids);
    }

    // later on jdk8
    private static List<Integer> findInvoiceNew(List<Invoice> invoices, Customer cust) {
	return invoices.stream().filter(inv -> inv.getCustomer() == cust).filter(i -> i.getAmount() > 5000).sorted(Comparator.comparingDouble(Invoice::getAmount)).map(Invoice::getId).collect(Collectors.toList());
    }

    // earlier to jdk8
    private static List<Integer> findInvoiceOld(List<Invoice> invoices, Customer cust) {
	List<Integer> ids = new ArrayList<>();

	List<Invoice> oracleCustInvoice = new ArrayList<>();
	for (Invoice invoice : invoices) {
	    if (invoice.getAmount() > 5000) {
		if (invoice.getCustomer() == cust) {
		    oracleCustInvoice.add(invoice);
		}
	    }
	}

	Collections.sort(oracleCustInvoice, new Comparator<Invoice>() {
	    @Override
	    public int compare(Invoice o1, Invoice o2) {
		return Double.compare(o1.getAmount(), o2.getAmount());
	    }
	});

	for (Invoice invoice : oracleCustInvoice) {
	    ids.add(invoice.getId());
	}

	return ids;
    }

}
