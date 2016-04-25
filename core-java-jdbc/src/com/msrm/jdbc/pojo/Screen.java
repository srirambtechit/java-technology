package com.msrm.jdbc.pojo;

public class Screen {

	private int id;

	private String name;

	private int theatreId;

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

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", theatreId=" + theatreId + "]";
	}

}
