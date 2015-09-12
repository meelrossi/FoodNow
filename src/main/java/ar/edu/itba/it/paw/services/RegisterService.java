package ar.edu.itba.it.paw.services;

import java.sql.SQLException;
import java.text.ParseException;

import ar.edu.itba.it.paw.dao.UserDao;

public class RegisterService {
	
	public int createUser(String name, String lastName, String address, String email, String birthdate, String password) {
		
		try {
			return UserDao.getInstance().createUser(name, lastName, address, email, birthdate, password);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
		
	}	

}
