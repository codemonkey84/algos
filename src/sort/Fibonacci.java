package sort;

import java.util.Scanner;

/**
 * Fibonacci without recursion
 *
 * @author anmishra
 */
public class Fibonacci {

	private static void create(long [] arr) {
		if (arr.length == 1) {
			arr[0] = 0;
		} else if (arr.length == 2) {
			arr[0] = 0;
			arr[1] = 1;
		} else if (arr.length > 2) {
			arr[0] = 0;
			arr[1] = 1;
			for (int i = 2; i < arr.length; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Hi! I am Fibonacci series. Please enter the length : ");
			int len = scanner.nextInt();
			long [] arr = new long[len];
			create(arr);
			System.out.println("Fibonacci series upto index "+len+" is:");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
	}
}