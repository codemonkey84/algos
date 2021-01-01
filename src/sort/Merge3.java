/**
 * 
 */
package sort;

import java.util.Scanner;

/**
 * Time complexity
 * ===============
 * Avg/Worst/Best - O(nlog n)
 * 
 * Space cpmplexity
 * ================
 * Worst - O(n)
 * 
 * @author amishra
 *
 */
public class Merge3 {

	/**
	 * @param args
	 */
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
			sort(arr, 0, len - 1);
			System.out.println();
			System.out.println("Sorted array : ");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
	}
	
	private static void merge (int [] arr, int start, int med, int end) {

		int [] arr1 = new int[med - start + 1];
		int [] arr2 = new int[end - med];
		
		System.arraycopy(arr, start, arr1, 0, arr1.length);
		System.arraycopy(arr, med + 1, arr2, 0, arr2.length);
		// Compare and copy
		int i = 0, j = 0, k = start;
		while (i < arr1.length && j < arr2.length) {
			
			if (arr1[i] <= arr2[j]) {
				arr[k++] = arr1[i++];
			}
			else {
				arr[k++] = arr2[j++];
			}
		}
		
		// copy the rest
		while (i < arr1.length) {
			arr[k++] = arr1[i++];
		}
		
		while (j < arr2.length) {
			arr[k++] = arr2[j++];
		}
	}

	private static void sort(int [] arr, int start, int end) {

		// Sort if only array has more than one element
		if (end > start) {
			int med = (end + start)/2;

			// Divide
			sort(arr, start, med);
			sort(arr, med + 1, end);
			
			// Conquer
			merge(arr, start, med, end);
		}
	}

}
