package com.msrm.jackson.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JsonIgnroeProperties should take JSON property name not POJO class property
 * name in order to omit particular field
 * 
 * @author sriram
 *
 */
@JsonIgnoreProperties({ "dept", "mobile" })
public class Person {

	private int id;

	private String name;

	private String department;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}
