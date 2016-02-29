package str;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Check if two strings are anagram.
 *
 */
public class Anagram {

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
			System.out.println(isAnagram(str1, str2));
		}
	}

	private static boolean isAnagram(String str1, String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		for (int i = 0; i < chars1.length; i++) {
			if (chars1[i] != chars2[i]) {
				return false;
			}
		}
		return true;
	}

}
