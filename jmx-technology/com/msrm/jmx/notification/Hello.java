package com.msrm.jmx.notification;

import javax.management.*;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

	// Attributes
	private String name = "HelloApp";
	private int cacheSize = 200;
	private int sequenceNumber = 1;

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
		int oldCacheSize = this.cacheSize;
		this.cacheSize = cacheSize;
		System.out.println("New cache size : " + cacheSize);

		Notification n = new AttributeChangeNotification(this, sequenceNumber++,
			System.currentTimeMillis(), "Cache size changed", "cacheSize", "int",
			oldCacheSize, this.cacheSize);

		sendNotification(n);
	}

	public int getCacheSize() {
		return this.cacheSize;
	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String [] types = {
			AttributeChangeNotification.ATTRIBUTE_CHANGE
		};
		String name = AttributeChangeNotification.class.getName();
		String description = "This MBean's attribute been changed";

		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);

		return new MBeanNotificationInfo[] {info};


	}

}
