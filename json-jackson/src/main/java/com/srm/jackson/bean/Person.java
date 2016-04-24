package com.srm.jackson.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Person {

	private int id;

	private String name;

	@JsonIgnoreProperties(ignoreUnknown = true)
	private String dept;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

}
