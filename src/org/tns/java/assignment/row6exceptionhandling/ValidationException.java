package org.tns.java.assignment.row6exceptionhandling;

@SuppressWarnings("serial")
public class ValidationException extends Exception {

	public ValidationException() {
		
	}
	public ValidationException(String message) {
		super(message);
	}
}
