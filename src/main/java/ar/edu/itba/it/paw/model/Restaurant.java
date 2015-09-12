package ar.edu.itba.it.paw.model;

import java.util.LinkedList;
import java.util.List;

public class Restaurant {
	private List<MenuCategory> menu;
	private double minAmount;
	private double deliveryCost;
	private String description;
	private String name;
	private Address address;
	private int id;
	private double rating;
	private String availableTime;
	
	public Restaurant(){
		this.menu= new LinkedList<MenuCategory>();
	}
	
	public Restaurant(List<MenuCategory> menu, double minAmount,
			String description, String name, Address address, int id, double rating) {
		super();
		this.menu = menu;
		this.minAmount = minAmount;
		this.description = description;
		this.name = name;
		this.address = address;
		this.id = id;
	}
	
	public Restaurant(double minAmount, String description, String name, Address address, int id, double rating) {
		this.minAmount = minAmount;
		this.description = description;
		this.name = name;
		this.address = address;
		this.id = id;
		this.setRating(rating);
	}
	
	public List<MenuCategory> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuCategory> menu) {
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
	
	public void setId(int id){
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
}