package ar.edu.itba.it.paw.dao;

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
	
	
}
