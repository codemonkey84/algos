/**
 * 
 */
package str;

import java.util.LinkedList;
import java.util.List;

/**
 * Implemented Rabin-Karp algorithm to calculate rolling hash of a sliding
 * string to avoid calculation of the hash of the entire string repetitively.
 * Whenever the window slides by one character decrement the hash value
 * corresponding to the first, and increment the hash corresponding to the new
 * next character
 * 
 * @author amishra
 *
 */
public class RollingHash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(indexOf("aabaaaab@$&*~ABSABB^&((123", "BB^"));
	}

	private static List<Integer> indexOf(String str, String pattern) {
		List<Integer> indexes = new LinkedList<>();
		String firstSnippet = str.substring(0, pattern.length());
		long hashCode = hashCode(firstSnippet);
		if (hashCode == hashCode(pattern)) {
			boolean matchFound = false;
			for (int indx = 0; indx < pattern.length(); indx++) {
				if (firstSnippet.charAt(indx) != pattern.charAt(indx)) {
					matchFound = false;
					break;
				}
				matchFound = true;
			}
			if (matchFound)
				indexes.add(0);
		}
		for (int indx = 1; indx < str.length() - pattern.length() + 1; indx++) {
			hashCode = updateHashCode(hashCode, str.charAt(indx - 1), str.charAt(indx + pattern.length() - 1), pattern.length());
			if (hashCode == hashCode(pattern)) {
				boolean matchFound = false;
				for (int i = indx, j = 0; j < pattern.length(); i++, j++) {
					if (str.charAt(i) != pattern.charAt(j)) {
						matchFound = false;
						break;
					}
					matchFound = true;
				}
				if (matchFound)
					indexes.add(indx);
			}
		}
		return indexes;
	}
	
	private static long hashCode(String s) {
		int hashCode = 0;
		for (int indx = 0; indx < s.length(); indx++) {
			int c = s.charAt(indx);
			hashCode += c * Math.pow(127, (s.length() - indx - 1));
		}
		return hashCode;
	}
	
	private static long updateHashCode(long hashCode, int remove, int append, int patternLength) {
		// reduce the value by removing the left most character
		hashCode -= remove * Math.pow(127, (patternLength - 1));
		// Increased the base since we need to shift the rest of the characters left
		hashCode *= 127;
		// increase the value for adding the right most character
		hashCode += append * Math.pow(127, 0);
		return hashCode;
	}
}
