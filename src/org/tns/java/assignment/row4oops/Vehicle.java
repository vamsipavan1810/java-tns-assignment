package org.tns.java.assignment.row4oops;

public abstract class Vehicle {
	private String brand;
	private int speed;
	private double price;
	public Vehicle() { }
	public Vehicle(String brand, int speed, double price) {
		this.brand = brand;
		this.speed = speed;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract void start();
	
	public void honk() {
		System.out.println("Playing Horn");
	}
	public void displayStatus() {
		System.out.println(brand + " is going with " + speed + "km/h");
	}
}
