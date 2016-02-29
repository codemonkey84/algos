package sort;

import java.util.Scanner;

/**
 * 
 * @author anmishra Time complexity: Avg/Worst - O(n^2), Best - O(n) Space
 *         cpmplexity: Worst - O(1)
 */
public class Insertion {

	private static void sort(int[] arr, int len) {
		for (int i = 0; i < len - 1; i++) {
			// Iterates over all the elems starting from adjacent next one to
			// the first one
			for (int j = i + 1; j > 0; j--) {
				// Check if current elem is lesser than adjacent previous one
				if (arr[j] < arr[j - 1]) {
					// Swap the elems
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print(
					"Hi! I am insertion sort (ascending) for int array. Please enter the length of the array : ");
			int len = scanner.nextInt();
			int[] arr = new int[len];
			for (int i = 0; i < len; i++) {
				System.out.println();
				System.out.print("Please enter the element at position " + (i + 1) + " : ");
				arr[i] = scanner.nextInt();
			}
			sort(arr, len);
			System.out.println();
			System.out.println("Sorted array : ");
			for (int i = 0; i < len; i++) {
				System.out.println(arr[i]);
			}
		}
	}
}