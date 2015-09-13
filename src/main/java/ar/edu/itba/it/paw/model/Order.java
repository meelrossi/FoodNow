package ar.edu.itba.it.paw.model;

import java.util.Calendar;
import java.util.LinkedList;

public class Order {
	private int id;
	private User user;
	private Address address;
	private LinkedList<Dish> dishes;
	private double total;
	private Restaurant restaurant;
	private Calendar date;

	public Order(int id, User user, Address address, LinkedList<Dish> dishes, double total, Restaurant restaurant,
			Calendar date) {
		super();
		this.id = id;
		this.user = user;
		this.address = address;
		this.dishes = dishes;
		this.total = total;
		this.restaurant = restaurant;
		this.setDate(date);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LinkedList<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(LinkedList<Dish> dishes) {
		this.dishes = dishes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
