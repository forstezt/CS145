package hw2;

public class Utilities {
	
	//converts cartesian points to string indexes
	public static int cartesianToIndex(int width, int height, int x, int y) {
		
		int index;
		
		//if the x and y coordinates are not within the bounds of the maze, returns -1
		//otherwise, returns the index of the serialized maze
		if ((x < 0) || (x > (width - 1)) || (y < 0) || (y > (height - 1))) {
			index = -1;
		} else {
			index = (width * y) + x;
		}
		
		return index;
	}
}

