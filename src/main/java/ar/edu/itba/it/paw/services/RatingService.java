package ar.edu.itba.it.paw.services;

import java.sql.SQLException;
import java.util.List;

import ar.edu.itba.it.paw.dao.RatingDao;
import ar.edu.itba.it.paw.model.Rating;

public class RatingService {
	
	public List<Rating> getRatingsForRestaurant(int restaurantID) {
		try {
			return RatingDao.getInstance().getRatingsForRestaurant(restaurantID);
		} catch (SQLException e) {
			System.out.println("SQLERROR ratings restaurant");
			return null;
		}
	}
}
