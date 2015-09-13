package ar.edu.itba.it.paw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Rating;

public class RatingDao extends Dao{
	public static RatingDao instance;

	public RatingDao() {
		super();
	}

	public static RatingDao getInstance() {
		if (instance == null) {
			return new RatingDao();
		}
		return instance;
	}
	
	public List<Rating> getRatingsForRestaurant(int restaurantID) throws SQLException {
		Statement stm;
		stm = connection.createStatement();
		String ratingQuery = "SELECT * FROM RATING WHERE RESTAURANT_ID =" + restaurantID;
		ResultSet rs = stm.executeQuery(ratingQuery);
		List<Rating> ratings = new LinkedList<Rating>();
		while(rs.next()) {
			Rating r = new Rating();
			r.setDescription(rs.getString("DESCRIPTION"));
			r.setRestaurantID(restaurantID);
			r.setValue(rs.getDouble("RATING_VALUE"));
			int userID = rs.getInt("FN_USER_ID");
			r.setUser(UserDao.getInstance().getUser(userID));
			ratings.add(r);
		}
		return ratings;
	}
	
	public void addRating(Rating rat, int userID) throws SQLException {
		String ratingQuery = "INSERT INTO RATING(FN_USER_ID, RESTAURANT_ID, DESCRIPTION, RATING_VALUE) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(ratingQuery, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setInt(1, userID);
		preparedStatement.setInt(2,rat.getRestaurantID());
		preparedStatement.setString(3,rat.getDescription());
		preparedStatement.setDouble(4, rat.getValue());
		preparedStatement.execute();
	}
}