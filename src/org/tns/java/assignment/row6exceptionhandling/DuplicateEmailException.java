package org.tns.java.assignment.row6exceptionhandling;

@SuppressWarnings("serial")
public class DuplicateEmailException extends Exception {

	public DuplicateEmailException() {
		
	}
	public DuplicateEmailException(String message) {
		super(message);
	}
}
