package com.msrm.jmx.mxbean;

public interface QueueSamplerMXBean {
	
	public QueueSample getQueueSample();

	public void clearQueue();

}
