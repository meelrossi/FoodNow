package ar.edu.itba.it.paw.services;

import java.sql.SQLException;
import java.util.List;

import ar.edu.itba.it.paw.dao.RestaurantDao;
import ar.edu.itba.it.paw.model.Restaurant;

public class RestaurantListService {

	public List<Restaurant> getRestaurants(String[] categories) {
		try {
			List<Restaurant> restaurants = RestaurantDao.getInstance().getRestaurantListByCategories(categories);
			return restaurants;
		} catch (SQLException e) {
			return null;
		}
	}
}
