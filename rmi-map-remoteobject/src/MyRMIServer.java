package com.msrm.rmi;

import java.rmi.Naming;

public class MyRMIServer {
	public static void main(String[] args) {
		try {
			Naming.rebind("ship", new ShipperImpl());
			System.out.println("RMI Server started");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
