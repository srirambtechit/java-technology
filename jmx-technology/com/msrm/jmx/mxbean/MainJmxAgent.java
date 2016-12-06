package com.msrm.jmx.mxbean;

import java.lang.management.*;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import javax.management.*;

public class MainJmxAgent {
	
	public static void main(String []args) throws Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.msrm.jmx.mxbean:type=QueueSampler");
		Queue<String> samples = new ArrayBlockingQueue<>(10);
		samples.add("Request-1");
		samples.add("Request-2");
		samples.add("Request-3");

		QueueSampler mbean = new QueueSampler(samples);
		mbs.registerMBean(mbean, name);

		System.out.println("Waiting...");
		Thread.sleep(Integer.MAX_VALUE);
	}

}
