package com.msrm.rmi;

import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ShipperImpl extends UnicastRemoteObject implements Shipper {

	private static final long servialVersionUID = 1L;

	public ShipperImpl() throws RemoteException {
		super();
	}

	public ArrayList<Product> ship(Integer[] ids, String [] names, Float[] prices) throws RemoteException {
		ArrayList<Product> list = new ArrayList<Product>();
		for(int i = 0;i < ids.length; i++) {
			list.add(new Product(ids[i], names[i], prices[i]));
		}
		return list;
	}	

}
