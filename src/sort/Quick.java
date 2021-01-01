package sort;

import java.util.Scanner;

/**
 * Time complexity
 * ===============
 *  Avg/Best - O(n * log n) 
 *  Worst - O(n^2) 
 *  
 *  Space cpmplexity
 *  ================
 *  Worst - O(log n)
 *  
 * @author anmishra
 */
public class Quick {

	private static void sort(int[] arr, int len) {
		performQuickSort(arr, 0, len - 1);
	}

	private static int determinePivotIndex (int [] arr, int start, int end) {
		int median = (start + end) / 2;
		int pivot = arr[median];
		int leftCursor = start, rightCursor = end;
		while (leftCursor < rightCursor) {
			/**
			 * As long as the current elem is lesser than pivot keep on
			 * comparing the next elem from left division with pivot
			 */
			while (leftCursor < rightCursor && arr[leftCursor] <= pivot) {
				leftCursor++;
			}
			
			/**
			 * As long as the current elem is greater than pivot keep on
			 * comparing the next elem from right division with pivot
			 */
			while (arr[rightCursor] > pivot) {
				rightCursor--;
			}
	        
	        /**
			 * If the current elem in left division is greater than pivot, and
			 * the current elem in right division is lesser than pivot swap both
			 * the elems
			 */		
			if (leftCursor < rightCursor) {
				int temp = arr[leftCursor];
				arr[leftCursor] = arr[rightCursor];
				arr[rightCursor] = temp;
			}
			
		}
		// Bring the pivot to it's correct position
		arr[median] = arr[rightCursor];
		arr[rightCursor] = pivot;
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		return rightCursor;
	}

	private static void performQuickSort (int [] arr, int start, int end) {
		if (start < end) {
			int pivotIndex = determinePivotIndex(arr, start, end);
			performQuickSort(arr, start, pivotIndex-1);
			performQuickSort(arr, pivotIndex + 1, end);
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