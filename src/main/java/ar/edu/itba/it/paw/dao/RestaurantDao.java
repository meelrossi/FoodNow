package ar.edu.itba.it.paw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Address;
import ar.edu.itba.it.paw.model.Dish;
import ar.edu.itba.it.paw.model.MenuCategory;
import ar.edu.itba.it.paw.model.Restaurant;

public class RestaurantDao extends Dao {
	public static RestaurantDao instance;

	public RestaurantDao() {
		super();
	}

	public static RestaurantDao getInstance() {
		if (instance == null) {
			instance = new RestaurantDao();
		}
		return instance;
	}

	public Restaurant getRestaurant(int id){
		try{
			Statement stm = connection.createStatement();
			String query = "SELECT * FROM RESTAURANT WHERE ID="+id;
			ResultSet queryrs = stm.executeQuery(query);
			Restaurant rest = new Restaurant();
			int restaurantid = 0;
			while(queryrs.next()){
				restaurantid=queryrs.getInt("ID");
				rest.setId(restaurantid);
				rest.setName(queryrs.getString("NAME"));
				rest.setDescription(queryrs.getString("DESCRIPTION"));
				rest.setRating(4);
				rest.setMinAmount(2);
			}
			String menuquery = "SELECT DISTINCT MENU_CATEGORY FROM DISH WHERE RESTAURANT_ID="+id;
			ResultSet menuqueryrs = stm.executeQuery(menuquery);
			MenuCategory menu = new MenuCategory();
			String menuCategory = "S";
			while(menuqueryrs.next()){
				menuCategory=menuqueryrs.getString("MENU_CATEGORY");
				menu.setCategoryName(menuCategory);
			}
			DishDao dishDao = DishDao.getInstance();
			List<Dish> dishlist = dishDao.getDishList(restaurantid, menuCategory);
			menu.setDishes(dishlist);
			List<MenuCategory> list = new LinkedList<MenuCategory>();
			list.add(menu);
			rest.setMenu(list);
			return rest;	
		}catch(Exception E){
			System.out.println("SQL Error: RestaurantDao exception");
			return null;
		}
	}

	public List<Restaurant> getRestaurantListByCategories(String[] categories) throws SQLException {
		Statement stm;
		stm = connection.createStatement();
		String restaurantQuery = "SELECT RESTAURANT.*, COALESCE(RATE.RATING,0) AS RATING FROM (SELECT RESTAURANT_ID, AVG(RATING_VALUE) AS RATING FROM RATING GROUP BY RESTAURANT_ID) AS RATE RIGHT OUTER JOIN RESTAURANT ON RATE.RESTAURANT_ID = RESTAURANT.ID";
		if (categories != null && categories.length > 0) {
			restaurantQuery += " WHERE ID IN (SELECT DISTINCT RESTAURANT_ID FROM DISH WHERE ";
			int i = 0;
			for (; i < categories.length - 1; i++) {
				restaurantQuery += "MENU_CATEGORY = \'" + categories[i] + "\' OR ";
			}
			restaurantQuery += "MENU_CATEGORY = \'" + categories[i] + "\')";

		}
		ResultSet restaurantQueryrs = stm.executeQuery(restaurantQuery);
		List<Restaurant> rlist = new LinkedList<Restaurant>();
		while (restaurantQueryrs.next()) {
			int id = restaurantQueryrs.getInt("ID");
			String description = restaurantQueryrs.getString("DESCRIPTION");
			String name = restaurantQueryrs.getString("NAME");
			int minAmount = restaurantQueryrs.getInt("MINAMOUNT");
			Address address = new Address("Roosevelt", 5471);
			double rating = restaurantQueryrs.getDouble("RATING");
			rlist.add(new Restaurant(minAmount, description, name, address, id, rating));
		}
		return rlist;
	}

	public void addRestaurant(Restaurant res) throws SQLException {
		String restaurantQuery = "INSERT INTO RESTAURANT(MINAMOUNT,DESCRIPTION, DELIVERY_COST, NAME, AVAILABLE_TIME) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(restaurantQuery, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setDouble(1, res.getMinAmount());
		preparedStatement.setString(2, res.getDescription());
		preparedStatement.setDouble(3, res.getDeliveryCost());
		preparedStatement.setString(4, res.getName());
		preparedStatement.setString(5, res.getAvailableTime());
		preparedStatement.execute();
		ResultSet restaurantKey = preparedStatement.getGeneratedKeys();
		AddressDao addDao = AddressDao.getInstance();
		while(restaurantKey.next()) {
			addDao.addAdressToRestaurant(restaurantKey.getInt(1),res.getAddress());
		}
		return;
	}

	public List<Restaurant> getRestaurantList(String category) {
		Statement stm;
		try {
			stm = connection.createStatement();
			String restaurantquery = "SELECT RESTAURANT.*, COALESCE(RATE.RATING,0) AS RATING FROM (SELECT RESTAURANT_ID, AVG(RATING_VALUE) AS RATING FROM RATING GROUP BY RESTAURANT_ID) AS RATE RIGHT OUTER JOIN RESTAURANT ON RATE.RESTAURANT_ID = RESTAURANT.ID";
			if (category != null) {
				restaurantquery += " WHERE ID IN (SELECT DISTINCT RESTAURANT_ID FROM DISH WHERE MENU_CATEGORY = \'"
						+ category + "\')";
			}
			ResultSet restaurantqueryrs = stm.executeQuery(restaurantquery);
			List<Restaurant> rlist = new LinkedList<Restaurant>();
			while (restaurantqueryrs.next()) {
				int id = restaurantqueryrs.getInt("ID");
				String description = restaurantqueryrs.getString("DESCRIPTION");
				String name = restaurantqueryrs.getString("NAME");
				int minAmount = restaurantqueryrs.getInt("MINAMOUNT");
				Address address = new Address("Roosevelt", 5471);
				int rating = restaurantqueryrs.getInt("RATING");
				rlist.add(new Restaurant(minAmount, description, name, address,
						id, rating));
			}
			return rlist;
		} catch (SQLException e) {
			System.out.println("SQL Exception: RestaurantList not found");
			e.printStackTrace();
			return null;
		}
	}
}
