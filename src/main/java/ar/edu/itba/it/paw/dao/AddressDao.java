package ar.edu.itba.it.paw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.edu.itba.it.paw.model.Address;

public class AddressDao extends Dao{
	public static AddressDao instance;

	public AddressDao() {
		super();
	}

	public static AddressDao getInstance() {
		if (instance == null) {
			instance = new AddressDao();
		}
		return instance;
	}
	
	public void addAdressToRestaurant(int restaurant_id, Address address) throws SQLException {
		String restaurantQuery = "INSERT INTO ADDRESS(STREET, STREET_NUMBER, RESTAURANT_ID) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(restaurantQuery, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, address.getStreet());
		preparedStatement.setInt(2,address.getNumber());
		System.out.println(restaurant_id);
		preparedStatement.setInt(3,restaurant_id);
		preparedStatement.execute();
	}
	
	public Address getRestaurantAddress(int restaurant_id) throws SQLException {
		Statement stm;
		stm = connection.createStatement();
		String addressQuery = "SELECT * FROM ADDRESS WHERE RESTAURANT_ID = " + restaurant_id;
		ResultSet addressRs = stm.executeQuery(addressQuery);
		Address add = new Address();
		while (addressRs.next()) {
			add.setStreet(addressRs.getString("STREET"));
			add.setNumber(addressRs.getInt("STREET_NUMBER"));
		}
		return add;
	}
}
