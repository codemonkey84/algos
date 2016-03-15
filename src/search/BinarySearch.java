/**
 * 
 */
package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anmishra Binary search implementation
 */
public class BinarySearch {

	public static void main(String[] args) {
		System.out.print("Please enter the length of the int array: ");
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int[] arr = new int[len];
		System.out.print("Please enter the integers: ");
		for (int i = 0; i < len; i++) {
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		System.out.print("Please enter the integer to search: ");
		int searchedElem = scanner.nextInt();
		System.out.println(search(arr, searchedElem, 0, len - 1));
		scanner.close();
	}

	private static boolean search(int[] arr, int searchedElem, int low, int high) {
		if (arr.length == 0) {
			return false;
		} else {
			int mid = low + (high - low) / 2;
			while (low < high) {
				if (searchedElem == arr[mid]) {
					return true;
				} else if (searchedElem < arr[mid]) {
					return search(arr, searchedElem, low, mid);
				} else {
					return search(arr, searchedElem, mid + 1, high);
				}
			}
			return false;
		}
	}
}
