package com.jlearn.jdbc;

import com.jlearn.jdbc.dao.MovieDAO;
import com.jlearn.jdbc.pojo.Movie;

public class TheatreApp {

	public static void main(String[] args) {

		Movie m = new Movie();
		m.setName("Mayajaal");
		MovieDAO dao = new MovieDAO();
		dao.insert(m);

	}

}
