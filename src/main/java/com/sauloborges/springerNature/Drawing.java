package com.sauloborges.springerNature;

import com.sauloborges.springerNature.excpetion.NotARectangleException;
import com.sauloborges.springerNature.excpetion.NullCanvasException;

public class Drawing {

	private String[][] CANVAS;

	/**
	 * Print the current status from the Canvas
	 */
	public void printCanvas() {
		for (int row = 0; row < getCANVAS().length; row++) {
			for (int col = 0; col < getCANVAS()[0].length; col++) {
				System.out.print(" " + getCANVAS()[row][col] + "|");
			}
			System.out.println(row);
		}
		int cont = 0;
		
		String line = "";
		String numbers = "";
		
		while (cont < getCANVAS()[0].length) {
			line = line + "___";
			numbers = numbers + String.format("%1$-" + 3 + "s", cont);
			cont++;
		}
		System.out.println(line);
		System.out.println(numbers);

	}

	/**
	 * Create a Rectangle
	 * @param x1 (coordinate X point 1)
	 * @param y1 (coordinate y point 1)
	 * @param x2 (coordinate X point 2)
	 * @param y2 (coordinate Y point 2)
	 * 
	 * @throws NotARectangleException: if a point 2 has any coordinate higher than point 1
	 * @throws NullCanvasException: when the canvas is not created yet
	 */
	public void createARectangle(int x1, int y1, int x2, int y2) throws NotARectangleException, NullCanvasException {
		if (x2 < x1 || y2 < y1) {
			throw new NotARectangleException();
		}
		if (CANVAS == null){
			throw new NullCanvasException();
		}
		createLine(x1, y1, x1, y2);
		createLine(x1, y2, x2, y2);
		createLine(x2, y1, x2, y2);
		createLine(x1, y1, x2, y1);
	}

	/**
	 * Create a new Canvas
	 * 
	 * @param width
	 * @param heigth
	 * 
	 * @throws NullCanvasException
	 */
	public void createACanvas(int width, int heigth) {
		setCANVAS(new String[heigth][width]);
		for (int row = 0; row < getCANVAS().length; row++) {
			for (int col = 0; col < getCANVAS()[0].length; col++) {
				getCANVAS()[row][col] = " ";
			}
		}
	}

	/**
	 * Print all points neighbors from the coordinate until find a 'x'.
	 * Always will search from the neigbor on the right, left, up and down
	 * 
	 * @param x
	 * @param y
	 * @param color
	 */
	private void printAndVerifyNeighbors(int x, int y, String color) {
		if (getCANVAS()[x][y].equals("x") || getCANVAS()[x][y].equals(color))
			return;
		else {
			getCANVAS()[x][y] = color;
			if (x + 1 < getCANVAS().length) // down
				printAndVerifyNeighbors(x + 1, y, color);
			if (y + 1 < getCANVAS()[0].length) // right
				printAndVerifyNeighbors(x, y + 1, color);
			if (x - 1 >= 0) // up
				printAndVerifyNeighbors(x - 1, y, color);
			if (y - 1 >= 0) // left
				printAndVerifyNeighbors(x, y - 1, color);
		}
	}
	
	public void fillCanvas(int x, int y, String color) throws NullCanvasException{
		if (CANVAS == null){
			throw new NullCanvasException();
		}
		
		printAndVerifyNeighbors(x, y, color);
	}

	/**
	 * Create a Line
	 * 
	 * @param x1 (coordinate X point 1)
	 * @param y1 (coordinate y point 1)
	 * @param x2 (coordinate X point 2)
	 * @param y2 (coordinate Y point 2)
	 * 
	 * @throws NullCanvasException: when the canvas is not created yet
	 */
	public void createLine(int x1, int y1, int x2, int y2) throws NullCanvasException {
		if (CANVAS == null){
			throw new NullCanvasException();
		}
		
		try {

			for (int row = x1; row <= x2; row++) {
				for (int col = y1; col <= y2; col++) {
					getCANVAS()[row][col] = "x";
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of bounds, try again");
		}
	}

	public String[][] getCANVAS() {
		return CANVAS;
	}

	public void setCANVAS(String[][] cANVAS) {
		CANVAS = cANVAS;
	}

}
