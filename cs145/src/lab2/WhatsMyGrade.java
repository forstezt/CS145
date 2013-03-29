package lab2;

public class WhatsMyGrade {
	public static void main(String[] args) {
		
		//Variables
		double midterm1, midterm2, finalExam, homework1, homework2, homework3, homework4, lab1, lab2, lab3, lab4, finalScore;
		
		//Assignments
		midterm1 = 88;
		midterm2 = 96;
		
		finalExam = 93;
		
		homework1 = 92;
		homework2 = 100;
		homework3 = 97;
		homework4 = 89;
		
		lab1 = 9;
		lab2 = 10;
		lab3 = 9;
		lab4 = 8;
		
		//Calculations
		finalScore = ((homework1 + homework2 + homework3 + homework4) / 400) * 50 +
							((lab1 + lab2 + lab3 + lab4) / 40) * 10 + 
							(midterm1 / 100) * 10 + 
							(midterm2 / 100) * 10 + 
							(finalExam / 100) * 20;
		
		//Output
		System.out.println(finalScore);	
	}
}
