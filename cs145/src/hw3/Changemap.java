package hw3;

import java.io.FileNotFoundException;

/**
 * reads in a series of image frames and writes the normalized accumulation of
 * the absolute values of the differences between each successive frame to a
 * file
 * 
 * @author Zach
 * 
 */
public class Changemap {

	/**
	 * finds the difference between every element in 2 2D arrays and returns
	 * these differences as another 2D array
	 * 
	 * @param array1
	 *            a 2D integer array
	 * @param array2
	 *            a 2D integer array to be subtracted from the first
	 * @return
	 */
	public static int[][] subtract(int[][] array1, int[][] array2) {

		// creates new array to be populated by the differences between 2 other
		// 2D arrays
		int[][] differences = new int[array1.length][array1[0].length];

		// fills subtractedArray with the differences between array1 and array2
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				differences[i][j] = array1[i][j] - array2[i][j];
			}
		}

		return differences;
	}

	/**
	 * takes the absolute value of all elements in a 2D array
	 * 
	 * @param array
	 *            the 2D integer array to be made positive
	 */
	public static void abs(int[][] array) {

		// takes every value in array to a positive value
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.abs(array[i][j]);
			}
		}
	}

	/**
	 * adds every element in one 2D integer array to the corresponding element
	 * of another
	 * 
	 * @param array1
	 *            a 2D integer array
	 * @param array2
	 *            a 2D integer array to be added to the first
	 */
	public static void accumulate(int[][] array1, int[][] array2) {

		// adds array2 to array1
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				array1[i][j] += array2[i][j];
			}
		}

	}

	/**
	 * proportionally compresses a 2D integer array into the range [0, 255]
	 * 
	 * @param array
	 *            2D integer array to be normalized
	 */
	public static void normalize(int[][] array) {

		// finds the minimum value in array
		int min = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] < min) {
					min = array[i][j];
				}
			}
		}

		// finds the maximum value in array
		int max = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}
		}

		// compresses array to the range [0, 255]
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (((array[i][j] - min) / (double) (max - min)) * 255);
			}
		}

	}

	/**
	 * reads in a series of image frames, finds the difference image between
	 * each one, takes the absolute value of those differences, adds them all
	 * up, normalizes them to the range [0, 255], and finally writes the final
	 * image frame to a pgm file
	 * 
	 * @param args
	 *            Includes the file to which the final image was written to, and
	 *            all of the files from which the images were read
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// creates a temporary array to represent the difference between 2 2D
		// arrays
		int[][] temporaryDifferences = new int[Graymap.readFromFile(args[1]).length][Graymap
				.readFromFile(args[1])[0].length];

		// creates an array to represent the accumulation of all the absolute
		// values of the temporary arrays
		int[][] accumulatedDifferences = new int[temporaryDifferences.length][temporaryDifferences[0].length];

		// adds all of the absolute values of the differences between arrays
		// representing image frames together
		for (int i = 1; i < (args.length - 1); i++) {
			temporaryDifferences = subtract(Graymap.readFromFile(args[i + 1]),
					Graymap.readFromFile(args[i]));
			abs(temporaryDifferences);
			accumulate(accumulatedDifferences, temporaryDifferences);
		}

		// normalizes and prints the 2D array representing the final image frame
		// to a file
		normalize(accumulatedDifferences);
		Graymap.writeToFile(accumulatedDifferences, args[0]);

	}
}
