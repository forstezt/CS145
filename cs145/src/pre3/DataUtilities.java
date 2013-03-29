package pre3;

public class DataUtilities {
	
	public static double[] add(double[] array1, double[] array2) {
		double[] addedArray = new double[array1.length];
		for (int i = 0; i < addedArray.length; i++) {
			addedArray[i] = array1[i] + array2[i]; 
		}
		return addedArray;
	}
	
	public static double getMinimum(double[] array) {
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	public static double getMaximum(double[] array) {
		double max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	public static double getSpan(double[] array) {
		double min = getMinimum(array);
		double max = getMaximum(array);
		double span = max - min;
		return span;
	}
	
	public static double[] normalize(double[] array) {
		double span = getSpan(array);
		double min = getMinimum(array);
		double[] normalizedArray = new double[array.length];
		
		for (int i = 0; i < normalizedArray.length; i++) {
			normalizedArray[i] = (array[i] - min) / span;
		}
		return normalizedArray;
	}
	
	public static double[] join(double[] array1, double[] array2) {
		double[] joinedArray = new double[array1.length + array2.length];
		for (int i = 0; i < joinedArray.length; i++) {
			if (i < array1.length) {
				joinedArray[i] = array1[i];
			} else {
				joinedArray[i] = array2[i - array1.length];
			}
		}
		return joinedArray;
	}
}
