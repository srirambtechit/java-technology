package com.msrm.rmi;

import java.util.Map;
import java.util.HashMap;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ShipperImpl extends UnicastRemoteObject implements Shipper {

	private static final long servialVersionUID = 1L;

	public ShipperImpl() throws RemoteException {
		super();
	}

	public Map<Integer, Product> ship(Integer[] ids, String [] names, Float[] prices) throws RemoteException {
		Map<Integer, Product> map = new HashMap<Integer, Product>();
		for(int i = 0;i < ids.length; i++) {
			map.put(ids[i], new Product(ids[i], names[i], prices[i]));
		}
		return map;
	}	

}
