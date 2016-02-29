package str;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: String reverse.
 *
 */
public class StringRev {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the string : ");
			String str = scanner.next();
			System.out.println(rev(str));
		}
	}

	private static String rev(String str) {
		char[] chars = new char[str.length()];
		for (int i = 0; i < chars.length; i++) {
			chars[chars.length - 1 - i] = str.charAt(i);
		}
		return new String(chars);
	}

}


