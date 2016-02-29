package sort;

import java.util.Scanner;

/**
 * 
 * @author anmishra Time complexity: Avg/Best - O(n * log n) Worst - O(n^2) Space cpmplexity:
 *         Avg/Worst - O(log n)
 */
public class Quick {

	private static void sort(int[] arr, int len) {
		quicksort(arr, 0, len - 1);
	}

	private static void quicksort(int[] arr, int low, int high) {
		int i = low, j = high;

		// Set the middle elem as pivot
		int pivot = arr[low + (high - low) / 2];

		while (i <= j) {
			/**
			 * As long as the current elem is lesser than pivot keep on
			 * comparing the next elem from left division with pivot
			 */
			while (arr[i] < pivot) {
				i++;
			}

			/**
			 * As long as the current elem is greater than pivot keep on
			 * comparing the next elem from right division with pivot
			 */
			while (arr[j] > pivot) {
				j--;
			}

			/**
			 * If the current elem in left division is greater than pivot, and
			 * the current elem in right division is lesser than pivot swap both
			 * the elems
			 */
			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}

			// Recursively sort the left division
			if (i < high) {
				quicksort(arr, i, high);
			}

			// Recursively sort the right division
			if (j > low) {
				quicksort(arr, low, j);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Hi! I am quick sort (ascending) for int array. Please enter the length of the array : ");
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