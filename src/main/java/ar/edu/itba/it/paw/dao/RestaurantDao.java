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

	public Restaurant getRestaurant(int id) {
		try {
			Statement stm = connection.createStatement();
			String query = "SELECT RESTAURANT.*, COALESCE(RATE.RATING,0) AS RATING FROM (SELECT RESTAURANT_ID, AVG(RATING_VALUE) AS RATING FROM RATING GROUP BY RESTAURANT_ID) AS RATE RIGHT OUTER JOIN RESTAURANT ON RATE.RESTAURANT_ID = RESTAURANT.ID WHERE RESTAURANT.ID="
					+ id;
			ResultSet queryrs = stm.executeQuery(query);
			Restaurant rest = new Restaurant();
			int restaurantid = 0;
			while (queryrs.next()) {
				restaurantid = queryrs.getInt("ID");
				rest.setId(restaurantid);
				rest.setName(queryrs.getString("NAME"));
				rest.setDescription(queryrs.getString("DESCRIPTION"));
				rest.setRating(queryrs.getDouble("RATING"));
				rest.setMinAmount(Integer.parseInt(queryrs.getString("MINAMOUNT")));
				rest.setAvailableTime(queryrs.getString("AVAILABLE_TIME"));
				rest.setDeliveryCost(queryrs.getDouble("DELIVERY_COST"));
			}
			Address add = AddressDao.getInstance().getRestaurantAddress(id);
			rest.setAddress(add);
			String menuquery = "SELECT DISTINCT MENU_CATEGORY FROM DISH WHERE RESTAURANT_ID=" + id;
			ResultSet menuqueryrs = stm.executeQuery(menuquery);
			String menuCategory = "";
			DishDao dishDao = DishDao.getInstance();
			List<MenuCategory> list = new LinkedList<MenuCategory>();
			while (menuqueryrs.next()) {
				menuCategory = menuqueryrs.getString("MENU_CATEGORY");
				MenuCategory menuCat = new MenuCategory();
				menuCat.setCategoryName(menuCategory);
				List<Dish> dishlist = dishDao.getDishList(restaurantid, menuCategory);
				menuCat.setDishes(dishlist);
				list.add(menuCat);

			}
			rest.setMenu(list);
			return rest;
		} catch (Exception E) {
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
			double rating = restaurantQueryrs.getDouble("RATING");
			Address add = AddressDao.getInstance().getRestaurantAddress(id);
			rlist.add(new Restaurant(minAmount, description, name, add, id, rating));
		}
		return rlist;
	}

	public void addRestaurant(Restaurant res) throws SQLException {
		String restaurantQuery = "INSERT INTO RESTAURANT(MINAMOUNT,DESCRIPTION, DELIVERY_COST, NAME, AVAILABLE_TIME) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(restaurantQuery,
				Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setDouble(1, res.getMinAmount());
		preparedStatement.setString(2, res.getDescription());
		preparedStatement.setDouble(3, res.getDeliveryCost());
		preparedStatement.setString(4, res.getName());
		preparedStatement.setString(5, res.getAvailableTime());
		preparedStatement.execute();
		ResultSet restaurantKey = preparedStatement.getGeneratedKeys();
		AddressDao addDao = AddressDao.getInstance();
		while (restaurantKey.next()) {
			addDao.addAdressToRestaurant(restaurantKey.getInt(1), res.getAddress());
		}
		return;
	}

	public String getRestaurantName(int restaurantID) throws SQLException {
		Statement stm;
		stm = connection.createStatement();
		String qry = "SELECT NAME FROM RESTAURANT WHERE ID = " + restaurantID;
		ResultSet rs = stm.executeQuery(qry);
		String name = "";
		while(rs.next()) {
			name = rs.getString("NAME");
		}
		return name;
	}
	
}
