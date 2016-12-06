package com.msrm.jmx.notification;

import java.lang.management.*;
import javax.management.*;

public class MainJmxAgent {
	
	public static void main(String []args) throws MalformedObjectNameException, 
										InstanceAlreadyExistsException, 
										MBeanRegistrationException, 
										NotCompliantMBeanException,
										InterruptedException {

		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.msrm.jmx.notification:type=Hello");
		Hello mbean = new Hello();
		mbs.registerMBean(mbean, name);

		System.out.println("Waiting forever");
		Thread.sleep(Integer.MAX_VALUE);

	}

}
