package lab6;

public class Truthtable {
	
	public static void main(String[] args) {
		
		int ageInYears = 26;
		int salaryInDollars = 40000;
		boolean isMale = false;
		int kidCount = 1;
		boolean isMarried = true;
		double avgWeeklyHoursWorked = 45.0;
		int birthMonth = 11;
		int birthYear = 1985;
		boolean drinksCoffee = false;
		
		boolean isBenefitsEligible = (avgWeeklyHoursWorked >= 20.0);
		boolean isTeenager = ((ageInYears >= 13) && (ageInYears <= 19));
		boolean isBachelor = !isMarried && isMale;
		boolean isBusy = ((kidCount > 0) || (avgWeeklyHoursWorked > 45.0));
		boolean notBornInOctober1990 = (!((birthMonth == 10) && (birthYear == 1990)));
		boolean goesToStarbucks = ((salaryInDollars > 30000) || (drinksCoffee));
		boolean canHaveChildren = ((isMale) || ((ageInYears < 45) && !(drinksCoffee)));
		
		System.out.println(isBenefitsEligible);
		System.out.println(isTeenager);
		System.out.println(isBachelor);
		System.out.println(isBusy);
		System.out.println(notBornInOctober1990);
		System.out.println(goesToStarbucks);
		System.out.println(canHaveChildren);
	}
}
