package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Restaurant;
import ar.edu.itba.it.paw.model.User;
import ar.edu.itba.it.paw.services.AsingRestaurantService;

public class AsingRestaurantController extends Controller {
	
private static final long serialVersionUID = 1L;
	//TODO: descomentar linea restaurants.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//this.userLvlCheck((Integer)req.getAttribute("userId"), MANAGER, resp, req);
		
		//List<Restaurant> restaurants = (new RestaurantListService()).getRestaurants(null);
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		restaurants.add(new Restaurant(2.2, "HOLA", "HOLA", null , 2, 4.5));
		System.out.println(restaurants);
		User user = null;
		try {
			user = (new AsingRestaurantService()).getUser(Integer.parseInt(req.getParameter("userId")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("restaurants", restaurants);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/jsp/asingRestaurant.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		int userId = Integer.parseInt(req.getParameter("userId"));
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		//TODO: hacer la llamada a la base de datos.
	}

}
