package list;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Find the beginning node of a cyclic
 *         (corrupted) single-linked list.
 *
 */
public class CyclicList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the list : ");
			String str = scanner.nextLine();
			LinkedList list = new LinkedList();
			for (int i = 0; i < str.length(); i++) {
				list.add(str.charAt(i));
			}
			System.out.println(findBeginning(list));
		}
	}

	private static char findBeginning(LinkedList list) {
		int i = 0;
		Set<Character> set = new HashSet<>();
		while(list.get(i) != null) {
			if (!set.add((Character)list.get(i))) {
				return (Character)list.get(i);
			}
			++i;
		}
		return '\0';
	}

}
