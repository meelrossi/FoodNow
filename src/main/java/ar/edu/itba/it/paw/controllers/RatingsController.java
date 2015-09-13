package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Rating;
import ar.edu.itba.it.paw.services.RatingService;
import ar.edu.itba.it.paw.services.RestaurantService;

public class RatingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantID = Integer.parseInt(req.getParameter("id"));
		List<Rating> ratings = (new RatingService()).getRatingsForRestaurant(restaurantID);
		req.setAttribute("ratings", ratings);
		String restaurantName = new RestaurantService().getRestaurantName(restaurantID);
		req.setAttribute("restaurantName", restaurantName);
		req.getRequestDispatcher("/WEB-INF/jsp/rating.jsp").forward(req, resp);
	}
}
