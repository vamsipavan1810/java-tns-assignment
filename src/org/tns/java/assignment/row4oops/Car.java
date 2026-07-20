package org.tns.java.assignment.row4oops;

public class Car extends Vehicle implements Drivable {
	public Car() { }
	public Car(String brand, int speed, double price) {
		super(brand, speed, price);
	}
	
	@Override
	 public void start() {
	     System.out.println("Car starts with key ignition.");
	 }

	 @Override
	 public void drive() {
	     System.out.println("Car is driving on the road.");
	 }
}
