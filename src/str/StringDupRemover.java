package str;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Remove duplicate chars from string.
 *
 */
public class StringDupRemover {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the string : ");
			String str = scanner.next();
			System.out.println(removeDup(str));
		}
	}

	private static String removeDup(String str) {
		char [] input = str.toCharArray();
		// Need to increase the storage if the string is non-ASCII
		boolean[] chars = new boolean[256];
		StringBuilder sb =new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			int indx = input[i];
			if (!chars[indx]) {
				sb.append(input[i]);
				chars[indx] = true;
			}
		}
		return sb.toString();
	}

}
