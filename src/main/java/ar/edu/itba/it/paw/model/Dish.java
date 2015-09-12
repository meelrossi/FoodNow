package ar.edu.itba.it.paw.model;

public class Dish {
	int id;
	String name;
	String description;
	double price;
	String menuCategory;
	
	public Dish() {
		
	}

	public Dish(int id, String name, String description, double price,
			String menuCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuCategory = menuCategory;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
}
