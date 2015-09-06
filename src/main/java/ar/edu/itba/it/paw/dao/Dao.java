package ar.edu.itba.it.paw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
	private static String database = "jdbc:postgresql://localhost/pawTest";
	private static String user = "FMZ";
	private static String password = "paw";
	protected Connection connection;
	
	public Dao() {
		connect();
	}
	
	protected void connect() {

		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(database, user, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
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
