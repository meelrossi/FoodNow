package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Address;
import ar.edu.itba.it.paw.model.MenuCategory;
import ar.edu.itba.it.paw.model.Restaurant;

public class RestaurantDao extends Dao {
	public static RestaurantDao instance;
	
	public RestaurantDao(){
		super();
	}
	
	public static RestaurantDao getInstance(){
		if (instance == null) {
			instance = new RestaurantDao();
		}
		return instance;
	}
	
	public Restaurant getRestaurant(int id){
		try{
			Statement stm = connection.createStatement();
			String query = "SELECT * FROM RESTAURANT WHERE ID="+"'"+id+"'";
			String menuquery = "SELECT DISTINCT MENU_CATEGORY FROM DISH WHERE RESTAURANT_ID="+"'"+id+"'";
			String addressquery = "SELECT * FROM ADDRESS WHERE ID="+"'"+id+"'";
			ResultSet queryrs = stm.executeQuery(query);
			ResultSet menuqueryrs = stm.executeQuery(menuquery);
			ResultSet addressqueryrs = stm.executeQuery(addressquery);
			Restaurant rest = null;
			while(queryrs.next()){
				String name = queryrs.getString("NAME");
				double minAmount = queryrs.getDouble("MINAMOUNT");
				String description = queryrs.getString("DESCRIPTION");
				List<MenuCategory> menue = new LinkedList<MenuCategory>();
				while(menuqueryrs.next()){
					menue.add(new MenuCategory(null, menuqueryrs.getString("MENU_CATEGORY")));
				}
				Address address = null;
				while(addressqueryrs.next()){
					String street = addressqueryrs.getString("STREET");
					int number = addressqueryrs.getInt("NUMBER");
					address = new Address(street, number);
				}
				rest = new Restaurant(menue, minAmount, description, name, address, id, 0);
			}
			return rest;	
		}catch(Exception E){
			System.out.println("SQL Error: restaurant exception");
			return null;
		}
	}
	
	public List<Restaurant> getRestaurantList(String category){
		Statement stm;
		try {
			stm = connection.createStatement();
			String restaurantquery = "SELECT RESTAURANT.*, COALESCE(RATE.RATING,0) AS RATING FROM (SELECT RESTAURANT_ID, AVG(RATING_VALUE) AS RATING FROM RATING GROUP BY RESTAURANT_ID) AS RATE RIGHT OUTER JOIN RESTAURANT ON RATE.RESTAURANT_ID = RESTAURANT.ID";
			if(category != null){
				restaurantquery += " WHERE ID IN (SELECT DISTINCT RESTAURANT_ID FROM DISH WHERE MENU_CATEGORY = \'" + category + "\')";
			}
			ResultSet restaurantqueryrs = stm.executeQuery(restaurantquery);
			List<Restaurant> rlist = new LinkedList<Restaurant>();
			while(restaurantqueryrs.next()){
				int id = restaurantqueryrs.getInt("ID");
				String description = restaurantqueryrs.getString("DESCRIPTION");
				String name = restaurantqueryrs.getString("NAME");
				int minAmount = restaurantqueryrs.getInt("MINAMOUNT");
				Address address = new Address("Roosevelt", 5471);
				int rating = restaurantqueryrs.getInt("RATING");
				rlist.add(new Restaurant(minAmount, description, name, address, id, rating));
			}
			return rlist;
		} catch (SQLException e) {
			System.out.println("SQL Exception: RestaurantList not found");
			e.printStackTrace();
			return null;
		}
	}
}
