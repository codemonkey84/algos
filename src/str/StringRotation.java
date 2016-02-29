package str;

import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Given two strings check if second string
 *         is rotated out of first one.
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
