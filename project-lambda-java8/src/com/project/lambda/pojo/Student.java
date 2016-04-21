package com.project.lambda.pojo;

public class Student {

	private int id;
	private String name;
	private double maths;
	private double english;
	private double tamil;
	private double science;
	private int graduationYear;

	public double total() {
		return maths + english + tamil + science;
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

	public double getMaths() {
		return maths;
	}

	public void setMaths(double maths) {
		this.maths = maths;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public double getTamil() {
		return tamil;
	}

	public void setTamil(double tamil) {
		this.tamil = tamil;
	}

	public double getScience() {
		return science;
	}

	public void setScience(double science) {
		this.science = science;
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	@Override
	public String toString() {
		return String.format("%2d - %-10s : tamil=%6.2f, english=%6.2f, maths=%6.2f, science=%6.2f, graduationYear=%4d",
				id, name, tamil, english, maths, science, graduationYear);
	}
	
}
