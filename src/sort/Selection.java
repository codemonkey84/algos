package sort;

import java.util.Scanner;

/**
 * 
 * @author anmishra Time complexity: Avg/Worst/Best - O(n^2) Space complexity:
 *         Worst - O(1)
 */
public class Selection {

	private static void sort(int[] arr, int len) {
		for (int i = 0; i < len - 1; i++) {
			// Assuming the first number as min
			int indx = i;
			int min = arr[indx];
			for (int j = i + 1; j < len; j++) {
				// Check if there is lesser number than min
				if (arr[j] < min) {
					// Keep track of the index of actual min
					indx = j;
					// Replace the earlier min with current min
					min = arr[indx];
				}
			}
			// Check if position of min changed, i.e. new min is discovered
			if (indx != i) {
				// Swap the assumed min with current min
				arr[indx] = arr[i];
				arr[i] = min;
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print(
					"Hi! I am selection sort (ascending) for int array. Please enter the length of the array : ");
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