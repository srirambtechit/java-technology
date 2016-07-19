package com.msrm.rmi;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Float price;


	public Product(Integer id, String name, Float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return "Product [id="+id+", name="+name+", price="+price+"]";
	}

}
