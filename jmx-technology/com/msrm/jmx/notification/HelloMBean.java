package com.msrm.jmx.notification;

public interface HelloMBean {

	public void sayHello();

	public int add(int a, int b);

	public String getName();

	public void setCacheSize(int cacheSize);

	public int getCacheSize();

}
