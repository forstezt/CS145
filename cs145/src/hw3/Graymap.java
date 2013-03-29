package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Graymap {

	/**
	 * reads in an image frame from a pgm file and puts the pixel intensities
	 * into a 2D array
	 * 
	 * @param filename
	 *            a path to a file from which to read one image frame
	 * @return
	 * @throws FileNotFoundException
	 */
	public static int[][] readFromFile(String filename)
			throws FileNotFoundException {

		// creates scanner
		Scanner fileReader = new Scanner(new File(filename));

		// reads through all of the general image information, including the
		// width and height
		fileReader.nextLine();
		int width = fileReader.nextInt();
		int height = fileReader.nextInt();
		fileReader.nextLine();

		// puts each and every pixel's intensity into a 2D array
		int[][] pixelIntensities = new int[height][width];
		for (int i = 0; i < pixelIntensities.length; i++) {
			for (int j = 0; j < pixelIntensities[0].length; j++) {
				pixelIntensities[i][j] = fileReader.nextInt();
			}
		}

		return pixelIntensities;
	}

	/**
	 * writes the general information and pixel densities for an image frame to
	 * a pgm file
	 * 
	 * @param pixelIntensities
	 *            a 2D integer array containing the pixel intensities to be
	 *            written to a file
	 * @param filename
	 *            a path to a file to which the image frame information will be
	 *            written
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(int[][] pixelIntensities, String filename)
			throws FileNotFoundException {

		// creates printwriter and designates the file to which it will write
		// information
		PrintWriter fileWriter = new PrintWriter(new File(filename));

		// writes general image frame information to a file
		fileWriter.println("P2");
		fileWriter.println(pixelIntensities[0].length + " "
				+ pixelIntensities.length);
		fileWriter.println("255");

		// writes a 2D array containing image frame pixel intensities to a file
		for (int i = 0; i < pixelIntensities.length; i++) {
			for (int j = 0; j < pixelIntensities[0].length; j++) {
				fileWriter.print(pixelIntensities[i][j] + " ");
			}
		}

		// closes printwriter
		fileWriter.flush();
		fileWriter.close();
	}
}
