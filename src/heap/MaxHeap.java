/**
 * 
 */
package heap;

import java.util.Scanner;

/**
 * Time Complexity:
 * ================
 *              Average		Worst case	Best Case
 * Space		O(n)		O(n)
 * Search		O(n)		O(n)
 * Insert		O(1)		O(log n)
 * Find-max		O(1)		O(1)
 * Delete-max	O(log n)	O(log n)
 * Heap Sort    O(n log n)  O(n log n)  O(n log n)
 * 
 * @author amishra
 *
 */
public class MaxHeap {

	static void heapify(int [] arr, int indx) {
		if (null != arr) {
			int largestIndx = indx;
			int leftChildIndx = 2 * indx + 1;
			int rightChildIndx = 2 * indx + 2;
			
			// compare and decide largest index
			if (leftChildIndx < arr.length && arr[leftChildIndx] > arr[largestIndx]) {
				largestIndx = leftChildIndx;
			}
			
			if (rightChildIndx < arr.length && arr[rightChildIndx] > arr[largestIndx]) {
				largestIndx = rightChildIndx;
			}
			
			// swap values if largest index has changed
			if (largestIndx != indx) {
				int temp = arr[indx];
				arr[indx] = arr[largestIndx];
				arr[largestIndx] = temp;
				
				// recursively heapify
				heapify (arr, largestIndx);
			}
		}
	}

	static void buildHeap(int [] arr) {
		if (null != arr) {
			for (int indx = arr.length - 1; indx >= 0; indx --)
				heapify(arr, indx);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Hi! let's build max heap from an int array. Please enter the length of the array : ");
			int len = scanner.nextInt();
			int[] arr = new int[len];
			for (int i = 0; i < len; i++) {
				System.out.println();
				System.out.print("Please enter the element at position " + (i + 1) + " : ");
				arr[i] = scanner.nextInt();
			}
			buildHeap(arr);
			System.out.println();
			System.out.println("Max Hep : ");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
		
	}

	
}
