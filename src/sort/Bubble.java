package sort;

import java.util.Scanner;

/**
 * 
 * @author anmishra Time complexity: Avg/Worst - O(n^2), Best - O(n) Space
 *         cpmplexity: Worst - O(1)
 */
public class Bubble {

	private static void sort(int[] arr, int len) {
		boolean isSwapped = false;
		do {
			// Resetting swap flag at the beginning of an iteration
			isSwapped = false;
			for (int i = 0; i < len - 1; i++) {
				// Check if adjacent elem is lesser than current one
				if (arr[i + 1] < arr[i]) {
					// Swap the elems
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					// Setting swap flag
					isSwapped = true;
				}
			}
		} while (isSwapped);// Keep on iterating as long as there is a single
							// swap
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Hi! I am bubble sort (ascending) for int array. Please enter the length of the array : ");
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