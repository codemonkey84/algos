package str;

import java.util.Scanner;

/**
 * 
 */

/**
 * Problem statement
 * =================
 * Given two strings check if second string is rotated out of first one.
 * 
 * Concatenate the original string with self, 2nd one is rotated of the 1st one
 * if it exists in the concatenated string
 * 
 * e.g. consider the original string as "abcd", concatenated with self it becomes
 * "abcdabcd". Now, all the possible rotated strings will be a valid substring of
 * the concatenated string.
 *
 * @author anmishra
 *
 */
public class StringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the 1st string : ");
			String str1 = scanner.next();
			System.out.println();
			System.out.print("Please enter the 2nd string : ");
			String str2 = scanner.next();
			System.out.println(isRotated(str1, str2));
		}
	}

	private static boolean isRotated(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		String str = str1.concat(str1);
		if (str.indexOf(str2) != -1) {
			return true;
		}
		return false;
	}

}
