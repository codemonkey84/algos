package str;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Replace space with %20.
 *
 */
public class StringReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the string : ");
			String str = scanner.nextLine();
			System.out.println();
			System.out.println(replace(str));
		}
	}

	private static String replace(String str) {
		int spaceCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				++spaceCount;
			}
		}
		int replacedStrLength = str.length()+ 2*spaceCount;
		char [] replacedChars = new char[replacedStrLength];
		for (int i = 0, j = 0; i < str.length() && j < replacedStrLength; i++) {
			if (str.charAt(i) == ' ') {
				replacedChars[j] = '%';
				replacedChars[++j] = '2';
				replacedChars[++j] = '0';
			} else {
				replacedChars[j] = str.charAt(i);
			}
			++j;
		}
		return new String(replacedChars);
	}

}
