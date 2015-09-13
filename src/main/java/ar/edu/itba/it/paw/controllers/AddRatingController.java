package ar.edu.itba.it.paw.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Rating;
import ar.edu.itba.it.paw.services.RatingService;

public class AddRatingController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurant = Integer.parseInt(req.getParameter("restaurantID"));
		double rating = Double.parseDouble(req.getParameter("rating"));
		String description = req.getParameter("description");
		Rating rat = new Rating();
		rat.setDescription(description);
		rat.setValue(rating);
		rat.setRestaurantID(restaurant);
		(new RatingService()).addRating(rat, 1);
		resp.sendRedirect("/FoodNow/restaurant?id=" + restaurant);
	}
}
