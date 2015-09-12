package ar.edu.itba.it.paw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
	private static String database = "jdbc:postgresql://localhost/pawTest";
	private static String user = "postgres";
	private static String password = "postgres";
	protected Connection connection;
	
	public Dao() {
		connect();
	}
	
	protected void connect() {

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(database, user, password);

		} catch (SQLException e) {

			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

		this.connection = connection;

	}
	
	public void closeConnection() throws SQLException {
		connection.close();
		
	}
}
