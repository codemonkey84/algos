/**
 * 
 */
package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Time Complexity: O (log n)
 *
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
		System.out.println("Found recursively at "+ binarySearchRecursive(arr, searchedElem, 0, len - 1));
		System.out.println("Found iteratively at "+ binarySearchIterative(arr, searchedElem));
		scanner.close();
	}

	private static int binarySearchIterative (int [] sortedArr, int input) {
		if (null != sortedArr) {
			int start = 0, end = sortedArr.length - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (input == sortedArr[mid])
					return mid;
				if (input < sortedArr[mid]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
	private static int binarySearchRecursive(int [] sortedArr, int input, int start, int end) {
		
		if (start <= end) {
			int median = (start + end) / 2;
			if (input == sortedArr[median])
				return median;
			if (input < sortedArr[median]) {
				return binarySearchRecursive(sortedArr, input, start, median - 1);
			}
			else {
				return binarySearchRecursive(sortedArr, input, median + 1, end);
			}
		}
		return -1;
	}

}
