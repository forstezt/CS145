package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

	// tries every possible path through the maze and prints out the path that
	// was used and the time taken for the computer to solve the maze
	public static void tryAllPossiblePaths(String maze, int width, int height,
			int x, int y, int endingX, int endingY, double time1) {

		// replaces the original coordinates with a 0, preventing
		// backtracking
		int index = Utilities.cartesianToIndex(width, height, x, y);
		maze = maze.substring(0, index) + '0'
				+ maze.substring(index + 1, maze.length());

		// checks for the availability of a path to the right of the current
		// coordinates, then sends a new "marker" along that path to see if it
		// is the correct path to completion
		if ((Utilities.cartesianToIndex(width, height, x + 1, y) != -1)
				&& (maze.charAt(Utilities.cartesianToIndex(width, height,
						x + 1, y)) == '.')) {

			// recalls the method, but this time starting from the new
			// coordinates
			Maze.tryAllPossiblePaths(maze, width, height, x + 1, y, endingX,
					endingY, time1);
		}

		// checks for the availability of a path to the left of the current
		// coordinates, then sends a new "marker" along that path to see if it
		// is the correct path to completion
		if ((Utilities.cartesianToIndex(width, height, x - 1, y) != -1)
				&& (maze.charAt(Utilities.cartesianToIndex(width, height,
						x - 1, y)) == '.')) {

			// recalls the method, but this time starting from the new
			// coordinates
			Maze.tryAllPossiblePaths(maze, width, height, x - 1, y, endingX,
					endingY, time1);
		}

		// checks for the availability of a path above the current coordinates,
		// then sends a new "marker" along that path to see if it is the correct
		// path to completion
		if ((Utilities.cartesianToIndex(width, height, x, y + 1) != -1)
				&& (maze.charAt(Utilities.cartesianToIndex(width, height, x,
						y + 1)) == '.')) {

			// recalls the method, but this time starting from the new
			// coordinates
			Maze.tryAllPossiblePaths(maze, width, height, x, y + 1, endingX,
					endingY, time1);
		}

		// checks for the availability of a path below the current coordinates,
		// then sends a new "marker" along that path to see if it is the correct
		// path to completion
		if ((Utilities.cartesianToIndex(width, height, x, y - 1) != -1)
				&& (maze.charAt(Utilities.cartesianToIndex(width, height, x,
						y - 1)) == '.')) {

			// recalls the method, but this time starting from the new
			// coordinates
			Maze.tryAllPossiblePaths(maze, width, height, x, y - 1, endingX,
					endingY, time1);
		}

		// checks for whether or not the computer has completed the maze
		if ((x == endingX) && (y == endingY)) {

			// prints the maze with an 8 at the ending point and 0's marking the
			// path that the computer took to get there
			print(maze, width, height, x, y);

			// calculates the total time taken by the computer to solve the maze
			double time2 = System.currentTimeMillis();
			double timeToSolve = (time2 - time1) / 1000;

			// prints that the maze has been completed and how long it took
			System.out
					.println("Wow, your computer is pretty smart!  It finished the maze in "
							+ timeToSolve + " seconds!");
		}

		return;
	}

	// reads a maze from a file and has the computer solve it automatically
	public static void autotraverse(String filename)
			throws FileNotFoundException {

		// imports a maze from a file
		Scanner fileReader = new Scanner(new File(filename));

		// reads the dimensions, starting coordinates, and ending coordinates
		// from the file
		int width = fileReader.nextInt();
		int height = fileReader.nextInt();
		int startingX = fileReader.nextInt();
		int startingY = fileReader.nextInt();
		int endingX = fileReader.nextInt();
		int endingY = fileReader.nextInt();

		// reads the maze from the file line by line and serializes it
		String maze = "";
		while (fileReader.hasNextLine()) {

			String line = fileReader.nextLine();
			maze = maze + line;
		}

		// initializes x, y, and the time
		int x = startingX;
		int y = startingY;
		double time1 = System.currentTimeMillis();

		// calls the method that automatically solves the maze
		Maze.tryAllPossiblePaths(maze, width, height, x, y, endingX, endingY,
				time1);

	}

	// prints the maze with an '8' marking the user's current place in the maze
	public static void print(String maze, int width, int height, int x, int y) {

		// changes the coordinates of the marker to the index of a string
		int index = Utilities.cartesianToIndex(width, height, x, y);

		// replaces whatever character exists at this index with an '8'
		maze = maze.substring(0, index) + '8'
				+ maze.substring(index + 1, maze.length());

		// prints out the maze, line by line
		int a = 0;
		for (int i = 0; i < height; i++) {

			System.out.println(maze.substring(a, a + width));
			a = a + width;
		}
	}

	// uses user input to move about the maze
	public static void traverse(String maze, int width, int height,
			int startingX, int startingY, int endingX, int endingY) {

		Scanner in = new Scanner(System.in);

		// gives directions to the user regarding how to use the program
		System.out.println("Welcome to the amazing maze!");
		System.out.println("Press 'q' to quit.");
		System.out.println("Press 'w' to move the marker upwards!");
		System.out.println("Press 's' to move the marker downwards!");
		System.out.println("Press 'd' to move the marker right!");
		System.out.println("Press 'a' to move the marker left!");

		// initializes x, y, and time
		double time1 = System.currentTimeMillis();
		int x = startingX;
		int y = startingY;

		// loop that continues to prompt the user for directions until they
		// complete the maze
		while (!((x == endingX) && (y == endingY))) {

			// prints the original maze with the marker at the starting point
			print(maze, width, height, x, y);

			// prompts the user for input
			System.out.print(">");
			String prompt = in.next().toLowerCase();

			// terminates the program if 'q' is entered
			if (prompt.equals("q")) {

				return;

				// moves the marker one coordinate upwards is 'w' is entered
			} else if (prompt.equals("w")) {

				y--;

				// does not move marker and re-prompts if the input leads into a
				// wall or out of the maze
				if ((Utilities.cartesianToIndex(width, height, x, y) == -1)
						|| (maze.charAt(Utilities.cartesianToIndex(width,
								height, x, y)) == '*')) {
					
					System.out.println("You can't go that way!");
					y++;
				}

				// moves the marker one coordinate to the left is 'a' is entered
			} else if (prompt.equals("a")) {

				x--;

				// does not move marker and re-prompts if the input leads into a
				// wall or out of the maze
				if ((Utilities.cartesianToIndex(width, height, x, y) == -1)
						|| (maze.charAt(Utilities.cartesianToIndex(width,
								height, x, y)) == '*')) {
					
					System.out.println("You can't go that way!");
					x++;
				}

				// moves the marker one coordinate downwards is 's' is entered
			} else if (prompt.equals("s")) {

				y++;

				// does not move marker and re-prompts if the input leads into a
				// wall or out of the maze
				if ((Utilities.cartesianToIndex(width, height, x, y) == -1)
						|| (maze.charAt(Utilities.cartesianToIndex(width,
								height, x, y)) == '*')) {
					
					System.out.println("You can't go that way!");
					y--;
				}

				// moves the marker one coordinate to the right is 'd' is
				// entered
			} else if (prompt.equals("d")) {

				x++;

				// does not move marker and re-prompts if the input leads into a
				// wall or out of the maze
				if ((Utilities.cartesianToIndex(width, height, x, y) == -1)
						|| (maze.charAt(Utilities.cartesianToIndex(width,
								height, x, y)) == '*')) {
					
					System.out.println("You can't go that way!");
					x--;
				}

				// rejects the input if it is not valid
			} else {

				System.out.println("Huh?");
			}

			// checks for whether or not the computer has completed the maze
			if ((x == endingX) && (y == endingY)) {

				// prints the maze with an '8' at the final coordinates and
				// congratulates user for completion
				print(maze, width, height, x, y);
				System.out
						.println("Congratulations!  You have completed the maze!");

				// calculates total time taken to solve the maze
				double time2 = System.currentTimeMillis();
				double timeToSolve = (time2 - time1) / 1000;

				// prints total time taken to solve the maze
				System.out.println("The maze took you " + timeToSolve
						+ " seconds to solve.");
			}

		}
	}

	// reads a maze from a file, generates a serialized version of the maze, and
	// depending on user preference, allows the user to solve the maze or
	// automatically solves it
	public static void traverse(String filename) throws FileNotFoundException {

		// reads in a file with a maze in it
		Scanner fileReader = new Scanner(new File(filename));
		
		// reads in the dimensions, starting coordinates, and ending coordinates
		// from a file
		int width = fileReader.nextInt();
		int height = fileReader.nextInt();
		int startingX = fileReader.nextInt();
		int startingY = fileReader.nextInt();
		int endingX = fileReader.nextInt();
		int endingY = fileReader.nextInt();

		// reads the maze line by line and serializes
		String maze = "";
		while (fileReader.hasNextLine()) {
			
			String line = fileReader.nextLine();
			maze = maze + line;
		}

		fileReader.close();

		traverse(maze, width, height, startingX, startingY, endingX, endingY);

	}

	// takes in a file path as a string and runs the program
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);

		// prompts the user to enter a file path
		System.out.println("Please enter a file from which to read the maze.");
		String filename = in.nextLine();

		// prompts the user to either complete the maze their selves or have the
		// computer do it for them
		System.out
				.println("Would you like to complete the maze yourself?  Enter yes or no.");
		String completeMazeOnOwn = in.next().toLowerCase();

		// has the computer automatically solve the maze
		if (completeMazeOnOwn.equals("no")) {

			autotraverse(filename);

			// has the user complete the maze
		} else {

			traverse(filename);
		}

	}
}
