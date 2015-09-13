package ar.edu.itba.it.paw.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
			String lastname = rs.getString("LASTNAME");
			String password = rs.getString("PASSWORD");
			int id = rs.getInt("ID");
			Calendar birthDate = Calendar.getInstance();
			birthDate.setTime(rs.getDate("BIRTHDATE"));// all done
			int userLevel = rs.getInt("FN_USER_LEVEL");
			user = new User(id, name, lastname, null, email, password, birthDate, userLevel);
		}
		return user;
	}

	
	public int createUser(String name, String lastName, String address, String email, String birthdate, String password, int userLvl) throws ParseException, SQLException {
		
		PreparedStatement stm;
		PreparedStatement addressStm;
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		Date date = new Date(formatter.parse(birthdate).getTime());
	
		String qry = "INSERT INTO FN_USER (name, lastname, email, birthdate, password, fn_user_level) VALUES (  ? , ? , ? , ? , ? , ? )";
		stm = connection.prepareStatement(qry);
		stm.setString(1, name);
		stm.setString(2, lastName);
		stm.setString(3, email);
		stm.setDate(4, date);
		stm.setString(5, password);
		stm.setInt(6, userLvl);
		
		int code = stm.executeUpdate();
		
		User user = getUser(email);
		
		String addressQry = "INSERT INTO ADDRESS (id, address) VALUES (  ? , ?  )";
		addressStm = connection.prepareStatement(addressQry);
		addressStm.setInt(1, user.getId());
		addressStm.setString(2, address);
		
		int addrCode = addressStm.executeUpdate();
		
		if(code != 1 || addrCode != 1)
			return 400;
		else
			return 200;
		
	}
	
	public User getUser(int id) throws SQLException{
		
		Statement stm = connection.createStatement();
		String qry = "SELECT * FROM FN_USER WHERE ID = " + id + ";";
		ResultSet rs = stm.executeQuery(qry);
		User user = null;
		while(rs.next()){
			String name = rs.getString("NAME");
			String lastname = rs.getString("LASTNAME");
			String password = rs.getString("PASSWORD");
			String email = rs.getString("EMAIL");
			Calendar birthDate = Calendar.getInstance();
			birthDate.setTime(rs.getDate("BIRTHDATE"));// all done
			int userLevel = rs.getInt("FN_USER_LEVEL");
			user = new User(id, name, lastname, null, email, password, birthDate, userLevel);
		}
		return user;
		
	}
	
	public int getUserLevel(int userId) throws SQLException{
		Statement stm;
		int userLevel = -1; // -1 IF USER NOT FOUND
		
		stm = connection.createStatement();
		String qry = "SELECT USER_LEVEL FROM USER WHERE ID =" + userId;
		ResultSet rs = stm.executeQuery(qry);
		while (rs.next()) {
			userLevel = rs.getInt("USER_LEVEL");
		}	
		
		return userLevel;
	}
}
