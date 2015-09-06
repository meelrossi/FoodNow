package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Dish;

public class DishDao extends Dao {
	public static DishDao instance;

	public DishDao() {
		super();
	}

	public static DishDao getInstance() {
		if (instance == null) {
			instance = new DishDao();
		}
		return instance;
	}

	public List<Dish> getDishList(int restaurantid, String menuCategory) {
		try {
			Statement stm = connection.createStatement();
			List<Dish> dishes = new LinkedList<Dish>();
			String dishquery = "SELECT * FROM DISH WHERE RESTAURANT_ID=" + "'"
					+ restaurantid + "'" + " AND MENU_CATEGORY=" + "'"
					+ menuCategory + "'";
			ResultSet dishqueryrs = stm.executeQuery(dishquery);
			while (dishqueryrs.next()) {
				int id = dishqueryrs.getInt("ID");
				String description = dishqueryrs.getString("DESCRIPTION");
				double price = dishqueryrs.getDouble("PRICE");
				String name = dishqueryrs.getString("NAME");
				Dish dish = new Dish(id, name, description, price, menuCategory);
				dishes.add(dish);
			}
			return dishes;

		} catch (Exception E) {
			System.out.println("SQL Error: DishDao exception");
			return null;
		}
	}
}
