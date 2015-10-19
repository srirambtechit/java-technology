package com.jaxb.demo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

    private int id;

    private String name;

    private double salary;

    private Date dob;

    private Date doj;

    private boolean active;

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

    public double getSalary() {
	return salary;
    }

    public void setSalary(double salary) {
	this.salary = salary;
    }

    public Date getDob() {
	return dob;
    }

    public void setDob(Date dob) {
	this.dob = dob;
    }

    public Date getDoj() {
	return doj;
    }

    public void setDoj(Date doj) {
	this.doj = doj;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    @Override
    public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dob=" + dob + ", doj=" + doj + ", active=" + active + "]";
    }

}
