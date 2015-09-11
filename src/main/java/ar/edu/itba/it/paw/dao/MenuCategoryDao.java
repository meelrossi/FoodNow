package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Dish;
import ar.edu.itba.it.paw.model.MenuCategory;

public class MenuCategoryDao extends Dao {
	public static MenuCategoryDao instance;

	public MenuCategoryDao() {
		super();
	}

	public static MenuCategoryDao getInstance() {
		if (instance == null) {
			return new MenuCategoryDao();
		}
		return instance;
	}

	public List<MenuCategory> getMenuCategoryList(int restaurantid) {
		try {
			List<MenuCategory> menuCategoryList = new LinkedList<MenuCategory>();
			DishDao dishdao = DishDao.getInstance();
			Statement stm = connection.createStatement();
			String menuCategoryquery = "SELECT DISTINCT MENU_CATEGORY FROM DISH WHERE ID=" + restaurantid;
			ResultSet menuCategoryrs = stm.executeQuery(menuCategoryquery);
			while (menuCategoryrs.next()) {
				String categoryName = menuCategoryrs.getString("MENU_CATEGORY");
				List<Dish> dishes = dishdao.getDishList(restaurantid, categoryName);
				menuCategoryList.add(new MenuCategory(dishes, categoryName));
			}
			return menuCategoryList;
		} catch (Exception E) {
			System.out.println("SQL Error: menu cateogry exception");
			return null;
		}
	}
	
	public List<String> getCategoryNameList() {
		List<String> categories = new LinkedList<String>();
		try {
			Statement stm = connection.createStatement();
			String qry = "SELECT DISTINCT MENU_CATEGORY FROM DISH";
			ResultSet rs = stm.executeQuery(qry);
			while(rs.next()) {
				String categoryName = rs.getString("MENU_CATEGORY");
				categories.add( categoryName);
			}
		} catch (Exception e) {
			System.out.println("SQL Error");
		}
		return categories;
	}
	
	public List<String> getCategoryNameList(int restaurantID) throws SQLException {
		List<String> categories = new LinkedList<String>();
		Statement stm = connection.createStatement();
		String qry = "SELECT DISTINCT MENU_CATEGORY FROM DISH WHERE RESTAURANT_ID =" +restaurantID;
		ResultSet rs = stm.executeQuery(qry);
		while(rs.next()) {
			String categoryName = rs.getString("MENU_CATEGORY");
			categories.add(categoryName);
		}
		return categories;
	}

}
