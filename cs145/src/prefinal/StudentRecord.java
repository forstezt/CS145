package prefinal;

public class StudentRecord {
	private int[] scores;
	
	public StudentRecord(int[] testScores) {
		scores = new int[testScores.length];
		for (int i = 0; i < testScores.length; i++) {
			scores[i] = testScores[i];
		}
	}
	
	public double average(int first, int last) {
		int total = 0;
		if (first >= 0 && last < scores.length && first <= last) {
			for (int i = first; i <= last; i++) {
				total += scores[i];
			}
		}
		
		return total / (double)(last - first + 1);
	}
	
	public boolean hasImproved() {
		int i = 0;
		while ((i + 1) == scores.length) {
			return false;
		}
		for (i = 0; i + 1 < scores.length; i++) {	
			while ((scores[i + 1]) < scores[i]) {
				return false;
			}
		}
		return true;
	}
	
	public double finalAverage() {
		if (hasImproved()) {
			return average((scores.length / 2), scores.length - 1);
		} else {
			return average(0, scores.length - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] testScores = {50, 51, 52, 53};
		StudentRecord record = new StudentRecord(testScores);
		System.out.println(record.finalAverage());
	}
}
