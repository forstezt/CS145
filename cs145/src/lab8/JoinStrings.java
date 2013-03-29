package lab8;

public class JoinStrings {
	public static String join(String[] array) {
		String joinedString = "";
		for (int i = 0; i < (array.length - 1); i++) {
			joinedString += (array[i] + ",");
		}
		joinedString += (array[array.length - 1]);
		return joinedString;
	}
	
	public static void main(String[] args) {
		String[] array = new String[5];
		array[0] = "asdf";
		array[1] = "aasdbf";
		array[2] = "yjest";
		array[3] = "lkfhg";
		array[4] = "98noin";
		
		String joinedString = join(array);
		System.out.println(joinedString);

	}
}
