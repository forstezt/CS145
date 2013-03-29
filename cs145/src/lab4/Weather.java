package lab4;

import java.util.Random;

public class Weather {
	
	public static void generateWeather() {
		
		Random generator = new Random();
		boolean rain = generator.nextBoolean();
		
		int highTemp = generator.nextInt(111);	
		int lowTemp = generator.nextInt(111);
		
		double highDecimal = generator.nextDouble();
		double lowDecimal = generator.nextDouble();
		
		while (lowTemp > highTemp) {
				highTemp = generator.nextInt(111);
				lowTemp = generator.nextInt(111);
			}
		
		System.out.println("High for the day:  " + (highTemp + highDecimal));
		System.out.println("Low for the day:  " + (lowTemp + lowDecimal));
		
		if (rain == true) {
			System.out.println("It will be raining");
		} else {
			System.out.println("It won't be raining");
		}
	}
	
	public static void main(String[] args) {
		generateWeather();
	}
}
