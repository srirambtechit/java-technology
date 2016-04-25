package com.msrm.jms.object.message;

import java.io.Serializable;

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public Event(int id, String name) {
	super();
	this.id = id;
	this.name = name;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "Event [id=" + id + ", name=" + name + "]";
    }

}
