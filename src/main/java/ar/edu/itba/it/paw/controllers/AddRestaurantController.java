package ar.edu.itba.it.paw.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Address;
import ar.edu.itba.it.paw.model.Restaurant;
import ar.edu.itba.it.paw.services.RestaurantService;

public class AddRestaurantController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/addRestaurant.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Restaurant rest = new Restaurant();
		Address add = new Address(req.getParameter("addressStreet"),(Integer.parseInt(req.getParameter("addressNumber"))));
		rest.setAddress(add);
		rest.setName(req.getParameter("name"));
		rest.setDeliveryCost(Double.parseDouble(req.getParameter("deliveryCost")));
		rest.setDescription(req.getParameter("description"));
		rest.setAvailableTime(req.getParameter("availableTime"));
		rest.setMinAmount(Double.parseDouble(req.getParameter("minAmount")));
		
		(new RestaurantService()).addRestaurant(rest);
		resp.sendRedirect("/FoodNow/restaurantList");
	}

}
