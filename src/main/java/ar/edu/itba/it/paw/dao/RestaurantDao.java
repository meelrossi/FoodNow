package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				rest = new Restaurant(menue, minAmount, description, name, address, id);
			}
			return rest;	
		}catch(Exception E){
			System.out.println("SQL Error");
			return null;
		}
	}
	
	public List<Restaurant> getRestaurantList() throws SQLException{
		Statement stm = connection.createStatement();
		String restaurantquery = "SELECT * FROM RESTAURANT";
		ResultSet restaurantqueryrs = stm.executeQuery(restaurantquery);
		List<Restaurant> rlist = new LinkedList<Restaurant>();
		while(restaurantqueryrs.next()){
			int id = restaurantqueryrs.getInt("ID");
			Restaurant restaurant = getRestaurant(id);
			rlist.add(restaurant);
		}
		return rlist;
	}
}
