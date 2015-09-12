package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


import ar.edu.itba.it.paw.model.Address;
import ar.edu.itba.it.paw.model.User;

public class UserDao extends Dao {
	private static UserDao instance;

	private UserDao() {
		super();
	}

	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	public User getUser(String email) throws SQLException, ParseException {
		Statement stm = connection.createStatement();
		System.out.println(email);
		String qry = "SELECT * FROM FN_USER WHERE EMAIL = '" + email + "';";
		ResultSet rs = stm.executeQuery(qry);
		User user = null;
		while(rs.next()){
			String name = rs.getString("NAME");
			String lastname = rs.getString("LASTMANE");
			String password = rs.getString("PASSWORD");
			int id = rs.getInt("ID");
			Calendar birthDate = Calendar.getInstance();
			birthDate.setTime(rs.getDate("BIRTHDATE"));// all done
			int userLevel = rs.getInt("FN_USER_LEVEL");
			user = new User(id, name, lastname, null, email, password, birthDate, userLevel);
		}
		return user;
	}

	
	public int createUser(String name, String lastName, String address, String email, String birthdate, String password) {
		
		Statement stm;
		
		try {
			stm = connection.createStatement();
			String qry = "INSERT INTO FN_USER VALUES (" + name + "," + lastName + "," + email + "," + birthdate + "," + password + ", 2 )";
			ResultSet rs = stm.executeQuery(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 400;
		}
		
		return 200;
		
	}
	public int getUserLevel(int userId) {
		Statement stm;
		int userLevel = -1; // -1 IF USER NOT FOUND
		try {
			stm = connection.createStatement();
			String qry = "SELECT USER_LEVEL FROM USER WHERE ID =" + userId;
			ResultSet rs = stm.executeQuery(qry);
			while (rs.next()) {
				userLevel = rs.getInt("USER_LEVEL");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception when getting userLevel");
			e.printStackTrace();
		}
		return userLevel;
	}
}
