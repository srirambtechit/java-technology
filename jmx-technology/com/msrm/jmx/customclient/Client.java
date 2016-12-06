package com.msrm.jmx.customclient;

import java.util.*;
import javax.management.*;
import javax.management.remote.*;

import com.msrm.jmx.notification.*;
import com.msrm.jmx.mxbean.*;

public class Client {
	
	private static class ClientListener implements NotificationListener {
		
		@Override
		public void handleNotification(Notification notification, Object handback) {
			System.out.print("Notification Received: ");
			System.out.format("className: %s, Source: %s, Type: %s, Message: %s%n", 
				notification.getClass().getName(), notification.getSource(), 
				notification.getType(), notification.getMessage());
			if(notification instanceof AttributeChangeNotification) {
				AttributeChangeNotification acn = (AttributeChangeNotification) notification;
				System.out.println("Attribute name: " + acn.getAttributeName());
				System.out.println("Attribute type: " + acn.getAttributeType());
				System.out.println("Old value: " + acn.getOldValue());
				System.out.println("New value: " + acn.getNewValue());
			}
		}

	}

	public static void main(String []args) throws Exception {
		System.out.println("Create an RMI connector client and connect it via RMI connector server");

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
		JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

		ClientListener listener = new ClientListener();

		serverInfo(mbsc);

/*
		// Perform operation via MBean proxy
		ObjectName mbeanName = new ObjectName("com.msrm.jmx.notification:type=Hello");
		HelloMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);

		// Registering listener
		mbsc.addNotificationListener(mbeanName, listener, null, null);
	    
		System.out.println("CacheSize = " + mbeanProxy.getCacheSize());

		mbeanProxy.setCacheSize(150);

		System.out.println("Waiting for notification...");
		Thread.sleep(2000);
		System.out.println("CacheSize = " + mbeanProxy.getCacheSize());
		System.out.println("Invoke sayHello() in Hello MBean...");
		mbeanProxy.sayHello();

		System.out.println("Invoke add(2, 3) in Hello MBean...");
		System.out.println("add(2, 3) = " + mbeanProxy.add(2, 3));	
*/

		// Perform operation via MXBean proxy
		ObjectName mxbeanName = new ObjectName("com.msrm.jmx.mxbean:type=QueueSampler");
		QueueSamplerMXBean mxbeanProxy = JMX.newMXBeanProxy(mbsc, mxbeanName, QueueSamplerMXBean.class);
		QueueSample queue1 = mxbeanProxy.getQueueSample();
		System.out.println("\nQueueSample.Date = " + queue1.getDate());
		System.out.println("QueueSample.Head = " + queue1.getHead());
		System.out.println("QueueSample.Size = " + queue1.getSize());
		System.out.println("\nInvoke clearQueue() in QueueSampler MXBean...");
		mxbeanProxy.clearQueue();

		QueueSample queue2 = mxbeanProxy.getQueueSample();
		System.out.println("\nQueueSample.Date = " +  queue2.getDate());
		System.out.println("QueueSample.Head = " + queue2.getHead());
		System.out.println("QueueSample.Size = " + queue2.getSize());

		jmxc.close();
		System.out.println("JMX Client closed");
	}

	private static void serverInfo(MBeanServerConnection mbsc) throws Exception {
		System.out.println("Domains: ");
		String [] domains = mbsc.getDomains();
		Arrays.sort(domains);
		for(String domain : domains) {
			System.out.println(domain);
		}

		System.out.println("Default domain: " + mbsc.getDefaultDomain());
		System.out.println("MBean count: " + mbsc.getMBeanCount());
		System.out.println("Query MBeanServer MBeans: ");
		Set<ObjectName> names = new TreeSet<>(mbsc.queryNames(null, null));
		for(ObjectName name : names) {
			System.out.println("ObjectName=" + name);
		}
	}

}
