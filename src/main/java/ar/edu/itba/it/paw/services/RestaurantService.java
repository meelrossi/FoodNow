package ar.edu.itba.it.paw.services;

import java.sql.SQLException;
import java.util.List;

import ar.edu.itba.it.paw.dao.RestaurantDao;
import ar.edu.itba.it.paw.model.Restaurant;

public class RestaurantService {

	public RestaurantService() {
		super();
	}

	public Restaurant getRestaurant(int id) throws SQLException {
		RestaurantDao restaurantDao = RestaurantDao.getInstance();
		Restaurant restaurant = restaurantDao.getRestaurant(id);
		return restaurant;
	}

	public int addRestaurant(Restaurant rest) {
		try {
			RestaurantDao restaurantDao = RestaurantDao.getInstance();
			restaurantDao.addRestaurant(rest);
			return 200;
		} catch (SQLException e) {
			return 400;
		}
	}

	public List<Restaurant> getRestaurants(String[] categories) {
		try {
			List<Restaurant> restaurants = RestaurantDao.getInstance().getRestaurantListByCategories(categories);
			return restaurants;
		} catch (SQLException e) {
			return null;
		}
	}

	public String getRestaurantName(int restaurantID) {
		String name = "";
		try {
			name = RestaurantDao.getInstance().getRestaurantName(restaurantID);
		} catch (SQLException e) {
			System.out.println("SQLError getRestaurantName");
		}
		return name;
	}
}
