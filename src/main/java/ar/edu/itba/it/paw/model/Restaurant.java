package ar.edu.itba.it.paw.model;

public class Restaurant {
	private Menu menu;
	private double minAmount;
	private String description;
	private String name;
	private Address address;
	private int id;
	
	public Restaurant(Menu menu, double minAmount, String description, String name, Address address,
			int id) {
		super();
		this.menu = menu;
		this.minAmount = minAmount;
		this.description = description;
		this.name = name;
		this.address = address;
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
}