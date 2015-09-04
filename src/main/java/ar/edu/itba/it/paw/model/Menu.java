package ar.edu.itba.it.paw.model;

import java.util.LinkedList;

public class Menu {
	LinkedList<MenuCategory> categories;

	public Menu(LinkedList<MenuCategory> categories) {
		super();
		this.categories = categories;
	}

	public LinkedList<MenuCategory> getCategories() {
		return categories;
	}

	public void setCategories(LinkedList<MenuCategory> categories) {
		this.categories = categories;
	}
}
