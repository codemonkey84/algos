import java.util.Scanner;

/**
 * 
 */

/**
 * @author anmishra Problem statement: Given an array of 0s and 1s, and k, Find
 *         the longest continuous streak of 1s after flipping k 0s to 1s.
 *
 */
public class AlgoProb1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the length of the array : ");
			int len = scanner.nextInt();
			int[] arr = new int[len];
			for (int i = 0; i < len; i++) {
				System.out.println();
				System.out.print("Please enter the element at position " + (i + 1) + " : ");
				arr[i] = scanner.nextInt();
			}
			System.out.println();
			System.out.print("Please enter how many 0s to be flipped to 1: ");
			int k = scanner.nextInt();
			System.out.println(solve(arr, k));
		}
	}

	private static int solve(int[] arr, int k) {
		int contiguousOneCountBefore = 0;
		int i = 0, len = 0;
		while (i < arr.length) {
			int contiguousZeroCount = 0, contiguousOneCountAfter = 0;
			while (i < arr.length && arr[i] == 1) {
				++contiguousOneCountBefore;
				++i;
			}
			while (i < arr.length && arr[i] == 0) {
				++contiguousZeroCount;
				++i;
			}
			while (i < arr.length && arr[i] == 1) {
				++contiguousOneCountAfter;
				++i;
			}
			if (contiguousZeroCount == k
					&& len < contiguousOneCountBefore + contiguousZeroCount + contiguousOneCountAfter) {
				len = contiguousOneCountBefore + contiguousZeroCount + contiguousOneCountAfter;
			}
			contiguousOneCountBefore = contiguousOneCountAfter;
		}
		return len;
	}

}
