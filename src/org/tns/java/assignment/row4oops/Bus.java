package org.tns.java.assignment.row4oops;


class Bus extends Vehicle implements Drivable {
	public Bus() { }
	public Bus(String brand, int speed, double price) {
		super(brand, speed, price);
	}
	
	@Override
	public void start() {
	    System.out.println("Bus starts with diesel engine.");
	}
	@Override
	public void drive() {
	    System.out.println("Bus is transporting passengers.");
	}
}