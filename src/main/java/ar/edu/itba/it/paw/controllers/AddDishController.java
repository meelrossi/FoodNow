package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Dish;
import ar.edu.itba.it.paw.services.DishService;
import ar.edu.itba.it.paw.services.MenuCategoryService;

public class AddDishController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantID = Integer.parseInt(req.getParameter("id"));
		List<String> restaurantMenuCategories = (new MenuCategoryService()).getMenuCategoriesForRestaurant(restaurantID);
		req.setAttribute("menuCategories", restaurantMenuCategories);
		req.getRequestDispatcher("/WEB-INF/jsp/addDish.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantID = Integer.parseInt(req.getParameter("id"));
		Dish dish = new Dish();
		dish.setDescription(req.getParameter("description"));
		dish.setMenuCategory(req.getParameter("menuCategory"));
		dish.setName(req.getParameter("dishName"));
		dish.setPrice(Double.parseDouble(req.getParameter("price")));
		(new DishService()).addDish(dish, restaurantID);
		resp.sendRedirect("/FoodNow/restaurant?id=" + restaurantID);
	}
}
