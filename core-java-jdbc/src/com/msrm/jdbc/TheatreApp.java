package com.msrm.jdbc;

import com.msrm.jdbc.dao.MovieDAO;
import com.msrm.jdbc.pojo.Movie;

public class TheatreApp {

	public static void main(String[] args) {

		Movie m = new Movie();
		m.setName("Mayajaal");
		MovieDAO dao = new MovieDAO();
		dao.insert(m);

	}

}
