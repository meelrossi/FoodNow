package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.management.relation.Role;

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

	public User getUser(String email) throws SQLException {
		Statement stm = connection.createStatement();
		String qry = "SELECT * FROM USER WHERE EMAIL =" + email;
		ResultSet rs = stm.executeQuery(qry);
		User user;
		while(rs.next()){
			String name = rs.getString("NAME");
			String lastname = rs.getString("LASTNAME");
			int id = rs.getInt("ID");
			Role role = new Role(rs.getString("ROLE"));
			Calendar birthDate = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd mm yyyy", Locale.US);
			birthDate.setTime(sdf.parse(rs.getString("BIRTHDATE")));// all done
			Address address = new Address(rs.getString("STREET"), rs.getInt("NUMBER"));
			user = new User(id, name, lastname, address, email, birthDate, role);
		}
			return user;
	}
}
