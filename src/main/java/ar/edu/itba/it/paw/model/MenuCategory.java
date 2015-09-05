package ar.edu.itba.it.paw.model;

import java.util.List;

public class MenuCategory {
	List<Dish> dishes;
	String categoryName;

	public MenuCategory(List<Dish> dishes, String categoryName) {
		super();
		this.dishes = dishes;
		this.categoryName = categoryName;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
