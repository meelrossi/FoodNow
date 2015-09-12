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
	
	public int createUser(String name, String lastName, String address, String email, String birthdate, String password) throws ParseException, SQLException {
		
		PreparedStatement stm;
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		Date date = new Date(formatter.parse(birthdate).getTime());
	
		String qry = "INSERT INTO FN_USER (name, lastmane, email, birthdate, password, fn_user_level) VALUES (  ? , ? , ? , ? , ? , ? )";
		stm = connection.prepareStatement(qry);
		stm.setString(1, name);
		stm.setString(2, lastName);
		stm.setString(3, email);
		stm.setDate(4, date);
		stm.setString(5, password);
		stm.setInt(6, 2);
		
		int code = stm.executeUpdate();
		
		if(code != 1)
			return 400;
		else
			return 200;
		
	}
}
