package ar.edu.itba.it.paw.services;
import java.sql.SQLException;

import ar.edu.itba.it.paw.dao.DishDao;
import ar.edu.itba.it.paw.model.Dish;

public class DishService {
	
	public int addDish(Dish dish, int restaurantID) {
		try {
			DishDao.getInstance().addDish(dish, restaurantID);
			return 1;
		} catch (SQLException e) {
			return 0;
		}
	}
}