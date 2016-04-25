package com.msrm.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.msrm.jdbc.pojo.Movie;

public class MovieDAO {

	public void insert(Movie m) {

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String sql = "INSERT INTO movie (name) VALUES (?)";

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, m.getName());
			int c = pst.executeUpdate();

			System.out.println("Count : " + c);

			if (c > 0)
				System.out.println("Movie Inserted");
			else
				System.out.println("Movie not inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Movie m) {

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String sql = "UPDATE movie set name = ? WHERE id = ?";

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, m.getName());
			pst.setInt(2, m.getId());

			pst.executeUpdate();

			System.out.println("Movie Updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Movie m) {

	}

	public Movie fetch(int id) {
		return null;
	}

}
