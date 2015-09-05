package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Dish;

public class DishDao extends Dao {
	public static DishDao instance;
	
	public DishDao(){
		super();
	}
	
	public DishDao getInstance(){
		if (instance == null) {
			instance = new DishDao();
		}
		return instance;
	}
	
	public List<Dish> getDishList(int restaurantid) throws SQLException{
		Statement stm = connection.createStatement();
		List<Dish> dishes = new LinkedList<Dish>();
		String dishquery = "SELECT * FROM DISH WHERE RESTAURANT_ID="+restaurantid;
		ResultSet dishqueryrs = stm.executeQuery(dishquery);
		while (dishqueryrs.next()){
			int id = dishqueryrs.getInt("ID");
			String description = dishqueryrs.getString("DESCRIPTION");
			double price = dishqueryrs.getDouble("PRICE");
			String name = dishqueryrs.getString("NAME");
			String menuCategory = dishqueryrs.getString("MENU_CATEGORY");
			Dish dish = new Dish(id, name, description, price, menuCategory);
			dishes.add(dish);
		}
		return dishes;
	}
}
