package ar.edu.itba.it.paw.controllers;

import java.sql.SQLException;
import java.util.List;

import ar.edu.itba.it.paw.dao.MenuCategoryDao;
import ar.edu.itba.it.paw.dao.RestaurantDao;
import ar.edu.itba.it.paw.model.MenuCategory;
import ar.edu.itba.it.paw.model.Restaurant;

public class RestaurantController {
	public Restaurant getRestaurant(int id) throws SQLException{
		RestaurantDao restaurantDao = RestaurantDao.getInstance();
		MenuCategoryDao	menuCategoryDao = MenuCategoryDao.getInstance();
		Restaurant restaurant = restaurantDao.getRestaurant(id);
		List<MenuCategory> menu = 
		restaurant.set
	}
}
