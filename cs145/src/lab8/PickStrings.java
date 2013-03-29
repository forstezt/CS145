package lab8;

import java.util.Random;

public class PickStrings {
	public static void main(String[] args) {
		Random pick = new Random();
		
		String[] names = new String[10];
		names[0] = "Tom";
		names[1] = "Zach";
		names[2] = "Tim";
		names[3] = "Bob";
		names[4] = "Cody";
		names[5] = "Aaron";
		names[6] = "Dakota";
		names[7] = "Jeremy";
		names[8] = "Dalton";
		names[9] = "Dustin";
		
		int namesPicked = 0;
		int name;
		
		String alreadyUsed = "";
		
		while (namesPicked < 5) {
			name = pick.nextInt(10);
			if (!alreadyUsed.contains("" + name)) {
				alreadyUsed += (name + ",");
				System.out.println(names[name]);
				namesPicked++;
			}		
		}
	}
}
