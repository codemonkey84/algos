package sort;

import java.util.Scanner;

/**
 * 
 * @author anmishra Time complexity: Avg/Worst/Best - O(nlogn) Space cpmplexity:
 *         Worst - O(n)
 */
public class Merge2 {

	private static int[] sort(int[] arr) {
		int[] result = new int[arr.length];
		if (arr.length > 1) {
			int midIndx = arr.length / 2;
			int[] left = new int[midIndx];
			int[] right;
			if (midIndx % 2 == 0) {
				right = new int[midIndx];
			} else {
				right = new int[midIndx + 1];
			}
			for (int i = 0; i < midIndx; i++) {
				left[i] = arr[i];
			}
			for (int j = midIndx, k = 0; j < arr.length; j++, k++) {
				right[k] = arr[midIndx];
			}

			sort(left);
			sort(right);
			result = merge(left, right);
		}
		return result;
	}

	private static int[] merge(int[] leftArr, int[] rightArr) {
		int[] resultArr = new int[leftArr.length + rightArr.length];
		int indxL = 0;
		int indxR = 0;
		int indxRes = 0;
		while (indxL <= leftArr.length && indxR <= rightArr.length) {
			if (leftArr[indxL] <= rightArr[indxR]) {
				resultArr[indxRes] = leftArr[indxL];
				indxL++;
			} else {
				resultArr[indxRes] = rightArr[indxR];
				indxR++;
			}
			indxRes++;
		}
		while (indxL <= leftArr.length) {
			resultArr[indxRes] = leftArr[indxL];
			indxL++;
			indxRes++;
		}
		while (indxR <= rightArr.length) {
			resultArr[indxRes] = rightArr[indxR];
			indxR++;
			indxRes++;
		}
		return resultArr;
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
			int[] result = sort(arr);
			System.out.println();
			System.out.println("Sorted array : ");
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
		}
	}
}