package ar.edu.itba.it.paw.services;

import java.sql.SQLException;
import java.util.List;

import ar.edu.itba.it.paw.dao.MenuCategoryDao;

public class MenuCategoryService {
	
	public List<String> getMenuCategories() {
		return MenuCategoryDao.getInstance().getCategoryNameList();
	}
	
	public List<String> getMenuCategoriesForRestaurant(int restaurantID) {
		try {
			return MenuCategoryDao.getInstance().getCategoryNameList(restaurantID);
		} catch (SQLException e) {
			System.out.println("getMenuCategories For restaurant SQLException");
			return null;
		}
	}
}
