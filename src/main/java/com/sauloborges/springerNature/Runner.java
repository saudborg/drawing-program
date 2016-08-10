package com.sauloborges.springerNature;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private static Drawing DRAW = new Drawing();

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Welcome to Drawing Program.");
		boolean running = true;
		while (running) {
			try {
				System.out.println("Please select one option: ");
				printOptionMenu();

				Scanner sc = new Scanner(System.in);
				String nextLine = sc.nextLine();

				String command = nextLine.substring(0, 1);
				String[] values = nextLine.split(" ");

				switch (command) {
				case "C":
					// create a canvas
					
					int width = Integer.valueOf(values[1]);
					int heigth = Integer.valueOf(values[2]);
					DRAW.createACanvas(width, heigth);
					break;

				case "L":
					// create a line
					
					int lX1 = Integer.valueOf(values[1]);
					int lY1 = Integer.valueOf(values[2]);
					int lX2 = Integer.valueOf(values[3]);
					int lY2 = Integer.valueOf(values[4]);

					DRAW.createLine(lX1, lY1, lX2, lY2);
					break;

				case "R":
					// create a rectangle
					
					int x1 = Integer.valueOf(values[1]);
					int y1 = Integer.valueOf(values[2]);
					int x2 = Integer.valueOf(values[3]);
					int y2 = Integer.valueOf(values[4]);

					DRAW.createARectangle(x1, y1, x2, y2);
					break;

				case "B":
					// fill
					
					int x = Integer.valueOf(values[1]);
					int y = Integer.valueOf(values[2]);
					String c = values[3];

					DRAW.fillCanvas(x, y, c);
					break;
					
				case "Q":
					// exit
					
					sc.close();
					running = false;
					break;
				}

				DRAW.printCanvas();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid coordenates. Please input a different");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private void printOptionMenu() {
		System.out.println("#	C w h 				- Create a new canvas of width w and height h.");
		System.out.println("#	L x1 y1 x2 y2 			- Create a new line from (x1,y1) to (x2,y2).");
		System.out.println(
				"#	R x1 y1 x2 y2 			- Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).");
		System.out.println("#	B x y c 			- Fill the entire area connected to (x,y) with \"colour\"");
		System.out.println("#	Q 				- Quit the program.");

	}

}
