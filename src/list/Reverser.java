package list;

import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Sum each elem of two lists into a
 *         resultant list in reverse order.
 *
 */
public class Reverser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the list : ");
			String str = scanner.next();
			LinkedList list = new LinkedList();
			for (int i = 0; i < str.length(); i++) {
				list.add(str.charAt(i));
			}
			list.reverse();
			System.out.println(list);
		}
	}	

}
