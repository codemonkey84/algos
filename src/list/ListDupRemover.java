package list;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Remove duplicate chars from list.
 *
 */
public class ListDupRemover {

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
			System.out.println(removeDup(list));
		}
	}

	private static LinkedList removeDup(LinkedList list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i+1; j < list.size(); j++) {
				if ((Character)(list.get(i)) == (Character)(list.get(j))) {
					list.remove(j);
				}
			}
		}
		return list;
	}

}


