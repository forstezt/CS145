package hw1;

public class Utilities {

	// Method to find valueM, which is between valueA and valueZ and which
	// occurs between timeA and timeZ
	public static double interpolate(double valueA, double timeA,
			double valueZ, double timeZ, double timeM) {

		// finds the percentage of timeM when taken from the entire time
		// interval between timeA and timeZ
		double percentage = (timeM - timeA) / (timeZ - timeA);
		
		// finds the jump in the valueA required to get to valueM
		double valueJump = percentage * (valueZ - valueA);
		
		// adds valueJump to valueA to find valueM
		double valueM = valueA + valueJump;

		return valueM;

	}
}
