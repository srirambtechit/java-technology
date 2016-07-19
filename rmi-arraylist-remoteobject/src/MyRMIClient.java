package com.msrm.rmi;

import java.rmi.Naming;

public class MyRMIClient {
	public static void main(String []args) {
		try {
			Shipper shipper = (Shipper) Naming.lookup("//localhost/ship");
			Integer[] ids = {1, 2, 3};
			String [] names = {"abc", "efg", "hij"};
			Float [] prices = {23.32f, 35.6f, 74.5f};
			System.out.println(shipper.ship(ids, names, prices));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
