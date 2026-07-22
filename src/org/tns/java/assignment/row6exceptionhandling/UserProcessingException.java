package org.tns.java.assignment.row6exceptionhandling;

@SuppressWarnings("serial")
public class UserProcessingException extends Exception {

	public UserProcessingException() {
		
	}
	public UserProcessingException(String message) {
		super(message);
	}
}
