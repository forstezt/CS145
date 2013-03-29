package lab8;

public class SortIntegers {
	public static void main(String[] args) {
		int[] ints = new int[10];
		ints[0] = 23;
		ints[1] = 2;
		ints[2] = 5;
		ints[3] = 10;
		ints[4] = 11;
		ints[5] = 1;
		ints[6] = 21;
		ints[7] = 18;
		ints[8] = 15;
		ints[9] = 12;
		
		int x;
		int min;
		int z;
		for (int i = 0; i < ints.length; i++) {
			min = ints[i];
			z = i;

			for (int j = (i + 1); j < ints.length; j++) {
				if (ints[j] < min) {
					min = ints[j];
					z = j;
				}
			}
			
			x = ints[i];
			ints[i] = min;
			ints[z] = x;
		}
		
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
}
