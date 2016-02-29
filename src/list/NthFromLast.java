package list;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Find nth elem from last of a single-linked list.
 *
 */
public class NthFromLast {

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
			System.out.print("Please enter the value of n: ");
			int n = scanner.nextInt();
			System.out.println(findFromLast(list, n));
		}
	}

	private static char findFromLast(LinkedList list, int n) {
		int i = 0, j = 0;
		while (list.get(i) != null) {
			if (i > n) {
				++j;
			}
			++i;
		}
		return (Character)list.get(j);
	}

}


