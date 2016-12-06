package com.msrm.jmx.mxbean;

import java.beans.ConstructorProperties;
import java.util.Date;

public class QueueSample {
	private Date date;
	private int size;
	private String head;

	@ConstructorProperties({"date", "size", "head"})
	public QueueSample(Date date, int size, String head) {
		this.date = date;
		this.size = size;
		this.head = head;
	}

	public Date getDate() {
		return this.date;
	}

	public int getSize() {
		return this.size;
	}

	public String getHead() {
		return this.head;
	}

}
