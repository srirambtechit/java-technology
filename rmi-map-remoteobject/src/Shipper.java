package com.msrm.rmi;

import java.util.Map;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Shipper extends Remote {
	public Map<Integer, Product> ship(Integer[] ids, String [] names, Float[] prices) throws RemoteException;
}
