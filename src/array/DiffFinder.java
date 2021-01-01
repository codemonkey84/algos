/**
 * 
 */
package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Problem Statement
 * =================
 * 
 * Write a function diff(arrA, arrB) that accepts two arrays and returns a new array that contains all values that are not contained in both input arrays. The order of numbers in the result array does not matter.

Examples
a = [1, 2, 3, 4]
b = [3, 4, 5, 6]

diff(a, b) # => [1, 2, 5, 6]
Note: we don't care if numbers are out of order or repeated; for example, these two arrays are equivalent since they are re-arrangements of the same values:

a = [1, 2, 1]
b = [2, 1, 2]

diff(a, b) # => []

 * @author amishra
 *
 */
public class DiffFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] output = diff(new int[] {1, 2, 3, 4}, new int[] {3, 4, 5, 6});
		for (int indx = 0; indx < output.length; indx++)
			System.out.print(output[indx]+ " ");
	}

	private static Integer[] diff(int[] arrA, int[] arrB) {


		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new LinkedList<>();

		for (int elem: arrA) { // O(m)
			set.add(elem); // O(1) * O(m)
		}
		for (int elem: arrB) { // O(n)
			if (!set.add(elem)) // O(1)* O(n)
				list.add(elem); // O(1)
		}
		list.stream().forEach(elem -> set.remove(elem)); // O(n) * O(1)
		return set.toArray(new Integer[0]);
		
	}
}
