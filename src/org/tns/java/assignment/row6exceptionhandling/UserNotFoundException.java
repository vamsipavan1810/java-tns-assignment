package org.tns.java.assignment.row6exceptionhandling;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{

	public UserNotFoundException() {
		
	}
	public UserNotFoundException(String message) {
		super(message);
	}
}
