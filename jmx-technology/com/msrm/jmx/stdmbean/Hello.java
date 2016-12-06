package com.msrm.jmx.stdmbean;

public class Hello implements HelloMBean {

	// Attributes
	private String name = "HelloApp";

	private int cacheSize = 200;

	// Operation
	public void sayHello() {
		System.out.println("Hello from JMX");
	}

	public int add(int a, int b) {
		return a + b;
	}

	// Attribute's operation
	public String getName() {
		return this.name;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
		System.out.println("New cache size : " + cacheSize);
	}

	public int getCacheSize() {
		return this.cacheSize;
	}

}
