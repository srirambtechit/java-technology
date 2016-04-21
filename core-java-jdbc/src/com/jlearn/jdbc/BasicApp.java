package com.jlearn.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicApp {

	public static void main(String[] args) {
		// insertTheatre("Sathiyam S2", "Adyar");
		// scrollResultWithUpdate();

		invokeProcedure();
	}

	public static void invokeProcedure() {
		Connection con = null;
		CallableStatement st = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=root");

			st = con.prepareCall("{call scount(?)}");
			st.registerOutParameter(1, java.sql.Types.INTEGER);
			st.executeUpdate();

			String result = st.getString(1);
			System.out.println("Procedure called, total screen count is " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void scrollResultWithUpdate() {
		String user = "root";
		String password = "root";
		String db = "cinema";
		String url = "jdbc:mysql://localhost:3306/" + db;

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE,
					ResultSet.CLOSE_CURSORS_AT_COMMIT);
			ResultSet rs = st.executeQuery("select * from theatre");
			if (rs.next()) {
				rs.updateString(2, "Sathiyam");
				rs.updateString(3, "Royapet");
				rs.updateRow();
			}
			con.close();
			System.out.println("terminated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertTheatre(String name, String address) {
		Connection con = null;
		Statement st = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?user=root&password=root");
			st = con.createStatement();
			int inserted = st
					.executeUpdate("INSERT INTO theatre(name, address) VALUES('" + name + "', '" + address + "')");
			if (inserted > 0)
				System.out.println("Data inserted");
			else
				System.out.println("Data not inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}