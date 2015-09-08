package ar.edu.itba.it.paw.services;

import java.util.HashMap;
import java.util.List;

import ar.edu.itba.it.paw.dao.RestaurantDao;
import ar.edu.itba.it.paw.model.Restaurant;

public class RestaurantListService {

	public List<Restaurant> getRestaurants(String category) {
		List<Restaurant> restaurants = RestaurantDao.getInstance().getRestaurantList(category);
		return restaurants;
	}
}
