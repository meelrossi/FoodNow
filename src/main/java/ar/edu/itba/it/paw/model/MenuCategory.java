package ar.edu.itba.it.paw.model;

import java.util.LinkedList;

public class MenuCategory {
	LinkedList<Dish> dishes;

	public MenuCategory(LinkedList<Dish> dishes, String categoryName) {
		super();
		this.dishes = dishes;
		this.categoryName = categoryName;
	}

	public LinkedList<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(LinkedList<Dish> dishes) {
		this.dishes = dishes;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	String categoryName;
}
