package ar.edu.itba.it.par.services;

import java.sql.SQLException;

import ar.edu.itba.it.paw.dao.UserDao;
import ar.edu.itba.it.paw.model.User;

public class LoginService {

	public int validate(String email, String password) throws SQLException {
		User user = UserDao.getInstance().getUser(email);
		if(user == null){
			return 404; //NOT FOUND
		} else if (user.getPassword().equals(password)) {
			return 200; // OK
		}
		return 406; //WRONG PASSWORD
	}
	
}
