package com.msrm.jackson.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = { "dept" })
public class PersonTwo {

	private int id;

	private String name;

	// mapping JSON property name mobile to POJO property
	@JsonProperty(value = "mobile")
	private String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PersonTwo [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}
