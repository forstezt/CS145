package hw3;

import java.io.FileNotFoundException;

class Test {
  
	/**
	 * Runs the main method of Changemap with the following filepaths passed in as command line arguments
	 * @param args
	 * Ignored
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
    String[] paths = { "C:\\Users\\Zach\\Desktop\\normalizedimage.pgm", "C:\\Users\\Zach\\Desktop\\hand000.pgm", "C:\\Users\\Zach\\Desktop\\hand001.pgm", "C:\\Users\\Zach\\Desktop\\hand002.pgm", "C:\\Users\\Zach\\Desktop\\hand003.pgm", "C:\\Users\\Zach\\Desktop\\hand004.pgm", "C:\\Users\\Zach\\Desktop\\hand005.pgm"};
    Changemap.main(paths);
  }
}