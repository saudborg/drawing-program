package com.sauloborges.springerNature.excpetion;

public class NotARectangleException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotARectangleException() {
		super("These coordinate are invalid to create a Rectangle");
	}
}
