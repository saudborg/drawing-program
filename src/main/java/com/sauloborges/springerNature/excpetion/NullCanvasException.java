package com.sauloborges.springerNature.excpetion;

public class NullCanvasException extends Exception {

	private static final long serialVersionUID = 7681882533667219893L;

	public NullCanvasException() {
		super("Please create a Canvas before you start");
	}
}
