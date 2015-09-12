package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Restaurant;
import ar.edu.itba.it.paw.services.RestaurantService;

public class RestaurantController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int restaurantid = Integer.parseInt(req.getParameter("id"));
		try{
			Restaurant restaurant = (new RestaurantService()).getRestaurant(restaurantid);
			req.setAttribute("restaurant", restaurant);
			req.getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp").forward(req, resp);
		}catch(SQLException E){
			System.out.println("SQL Error: failed to load restaurant controller");
		}
	}
}
