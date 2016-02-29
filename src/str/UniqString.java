package str;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Check if a string has all unique chars.
 *
 */
public class UniqString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the string : ");
			String str = scanner.next();
			System.out.println(isUniq(str));
		}
	}

	private static boolean isUniq(String str) {
		// Need to increase the storage if the string is non-ASCII
		boolean [] chars = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int indx = str.charAt(i);
			if (chars[indx]) return false;
			chars[indx] = true;
		}
		return true;
	}

}


