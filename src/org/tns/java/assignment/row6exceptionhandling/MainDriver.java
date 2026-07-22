package org.tns.java.assignment.row6exceptionhandling;

import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserFileProcessor userFileProcessor = new UserFileProcessor();
		userFileProcessor.readUsers("C:\\Users\\v.yalla\\Desktop\\Vamsi\\Assignments\\Java\\javaAssignments\\src\\org\\tns\\java\\assignment\\row6exceptionhandling\\users.csv");
		
		boolean execute = true;
		while(execute) {
			System.out.println("Select one option out of below:");
			System.out.println("1. Get user by ID.");
			System.out.println("2. Stop execution.");
			System.out.print("Enter your option: ");
			int op = sc.nextInt();
			if(op == 1) {
				System.out.print("Enter user ID: ");
				int id = sc.nextInt();
				
				try {
					User user = userFileProcessor.findUserById(id);
					System.out.println("\n" + user + "\n");
				} catch (UserNotFoundException e) {
					System.err.println("\n"  + e.getMessage() + "\n");
				}
			} else if(op == 2) {
				System.out.println("\nExecution completed");
				execute = false;
			} else {
				System.err.println("\nEnter the valid option.\n");
			}
		}
		sc.close();
	}
}
