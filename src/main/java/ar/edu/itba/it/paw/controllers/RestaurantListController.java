package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Restaurant;
import ar.edu.itba.it.paw.services.MenuCategoryService;
import ar.edu.itba.it.paw.services.RestaurantService;

public class RestaurantListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] categories = req.getParameterValues("category");
		List<Restaurant> restaurants = (new RestaurantService()).getRestaurants(categories);
		/*List<Action> actions = (ActionService.getInstance().getActions(0,"restaurantList"));*/

		List<String> menuCategories = new MenuCategoryService().getMenuCategories();
		
		req.setAttribute("restaurants", restaurants);
		//req.setAttribute("actions", actions);
		req.setAttribute("categories", menuCategories);
		req.getRequestDispatcher("/WEB-INF/jsp/restaurantList.jsp").forward(req, resp);
	}
}