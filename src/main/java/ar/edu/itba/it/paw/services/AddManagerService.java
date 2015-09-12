package ar.edu.itba.it.paw.services;

import java.sql.SQLException;
import java.text.ParseException;

import ar.edu.itba.it.paw.dao.UserDao;
import ar.edu.itba.it.paw.model.User;

public class AddManagerService {
	
	public User getUser(String email) throws SQLException, ParseException{
		
		return UserDao.getInstance().getUser(email);
		
	}

}
