package com.msrm.rmi;

import java.util.ArrayList;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Shipper extends Remote {
	public ArrayList<Product> ship(Integer[] ids, String [] names, Float[] prices) throws RemoteException;
}
