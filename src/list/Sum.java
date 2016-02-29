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
public class Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the 1st list : ");
			String str1 = scanner.next();
			LinkedList list1 = new LinkedList();
			for (int i = 0; i < str1.length(); i++) {
				list1.add(str1.charAt(i));
			}
			System.out.print("Please enter the 2nd list : ");
			String str2 = scanner.next();
			LinkedList list2 = new LinkedList();
			for (int i = 0; i < str2.length(); i++) {
				list2.add(str2.charAt(i));
			}
			System.out.println(sum(list1, list2));
		}
	}

	private static LinkedList sum(LinkedList list1, LinkedList list2) {
		if (list1.size() != list2.size()) {
			return null;
		}
		LinkedList list = new LinkedList();
		int res = 0;
		for (int i = 0; i < list1.size(); i++) {
			int sum = Character.getNumericValue((Character) list1.get(i))
					+ Character.getNumericValue((Character) list2.get(i)) + res;
			list.add(sum % 10);
			res = sum / 10;
		}
		if (res > 0) {
			list.add(res);
		}
		return list;
	}

}
