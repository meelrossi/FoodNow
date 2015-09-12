package ar.edu.itba.it.paw.services;

import java.sql.SQLException;

import ar.edu.itba.it.paw.dao.UserDao;
import ar.edu.itba.it.paw.model.User;

public class AsingRestaurantService {
	
	public User getUser(int id) throws SQLException{
		return UserDao.getInstance().getUser(id);
	}

}
