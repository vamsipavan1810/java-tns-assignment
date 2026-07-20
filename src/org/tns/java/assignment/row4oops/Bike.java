package org.tns.java.assignment.row4oops;

public class Bike extends Vehicle implements Drivable {
	public Bike() { }
	public Bike(String brand, int speed, double price) {
		super(brand, speed, price);
	}
	@Override
	 public void start() {
	     System.out.println("Bike starts with key ignition.");
	 }

	 @Override
	 public void drive() {
	     System.out.println("Bike is driving on the road.");
	 }
}
