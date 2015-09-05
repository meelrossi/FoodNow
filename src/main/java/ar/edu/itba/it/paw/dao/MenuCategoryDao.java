package ar.edu.itba.it.paw.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Dish;
import ar.edu.itba.it.paw.model.MenuCategory;

public class MenuCategoryDao extends Dao {
	public static MenuCategoryDao instance;
	
	public MenuCategoryDao(){
		super();
	}
	
	public static MenuCategoryDao getInstance(){
		if (instance == null){
			return new MenuCategoryDao();
		}
		return instance;
	}
	
	public List<MenuCategory> getMenuCategoryList(int restaurantid){
		try{
			List<MenuCategory> menuCategoryList = new LinkedList<MenuCategory>();
			DishDao dishdao = DishDao.getInstance();
			Statement stm = connection.createStatement();
			String menuCategoryquery = "SELECT MENU_CATEGORY FROM DISH WHERE ID='"+restaurantid+"'";
			ResultSet menuCategoryrs = stm.executeQuery(menuCategoryquery);
			while(menuCategoryrs.next()){
				String categoryName = menuCategoryrs.getString("MENU_CATEGORY");
				List<Dish> dishes = dishdao.getDishList(restaurantid, categoryName);
				menuCategoryList.add(new MenuCategory(dishes, categoryName));
			}
			return menuCategoryList;
		}catch(Exception E){
			System.out.println("SQL Error");
			return null;
		}
		
	}
	
	
}
