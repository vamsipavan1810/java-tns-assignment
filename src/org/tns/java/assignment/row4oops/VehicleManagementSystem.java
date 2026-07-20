package org.tns.java.assignment.row4oops;

public class VehicleManagementSystem {
	public static void main(String[] args) {
		Vehicle fortuner = new Car("Toyota", 220, 6000000);
		Vehicle gt650 = new Bike("Royal Enfield", 180, 550000);
		Vehicle bus = new Bus("Volvo", 140, 8000000);
		
		Vehicle[] vehicles = { fortuner, gt650, bus };
		
		System.out.println("\n    - - - - V E H I C L E S - - - -\n");
		
		for(Vehicle vehicle : vehicles) {
			vehicle.displayStatus();
			vehicle.start();
			vehicle.honk();
			System.out.println();
		}
		
		System.out.println("\n    - - - - D R I V I N G   V E H I C L E - - - -\n");
		
		for(Vehicle vehicle : vehicles) {
			Drivable driving = (Drivable) vehicle;
			driving.drive();
		}
	}
}
