package sort;

import java.util.Scanner;

/**
 * 
 * @author anmishra Time complexity: Avg/Worst/Best - O(n * logn) Space cpmplexity:
 *         Worst - O(n)
 */
public class Merge {

	private static int[] tmpArr;

	private static void sort(int[] arr, int len) {
		tmpArr = new int[arr.length];
		divide(arr, 0, len - 1);
	}

	private static void divide(int[] arr, int lowerIndx, int higherIndx) {
		if (lowerIndx < higherIndx) {
			int midIndx = lowerIndx + (higherIndx - lowerIndx) / 2;
			// Divide the 1st half
			divide(arr, lowerIndx, midIndx);
			// Divide the 2nd half
			divide(arr, midIndx + 1, higherIndx);
			// Merge all the partitions
			merge(arr, lowerIndx, midIndx, higherIndx);
		}
	}

	private static void merge(int[] arr, int lowerIndx, int midIndx, int higherIndx) {
		// Copy both parts into the temp array
		for (int i = lowerIndx; i <= higherIndx; i++) {
			tmpArr[i] = arr[i];
		}
		int i = lowerIndx, k = lowerIndx;
		int j = midIndx + 1;

		// Copy the min from left / right side into the original array
		while (i <= midIndx && j <= higherIndx) {
			if (tmpArr[i] <= tmpArr[j]) {
				arr[k] = tmpArr[i];
				i++;
			} else {
				arr[k] = tmpArr[j];
				j++;
			}
			k++;
		}

		// Copy the rest of the left side into the original array
		while (i <= midIndx) {
			arr[k] = tmpArr[i];
			i++;
			k++;
		}

	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Hi! I am merge sort (ascending) for int array. Please enter the length of the array : ");
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