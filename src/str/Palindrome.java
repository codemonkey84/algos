/**
 * 
 */
package str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amishra
 *
 */
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Palindrome().isPalindrome("a"));
		System.out.println(new Palindrome().isPalindrome("anna"));
		System.out.println(new Palindrome().isPalindrome("ana"));
		System.out.println(new Palindrome().isPalindrome("racecar"));
		System.out.println(new Palindrome().isPalindrome("eracecare"));
		
		System.out.println(new Palindrome().isPalindrome("ab"));
		System.out.println(new Palindrome().isPalindrome("abc"));
		System.out.println(new Palindrome().isPalindrome("cracecarc"));
	}

	private boolean isPalindrome(String str) {
		if (null == str)
			return false;
		if (str.length() <= 1)
			return true;
		
		Map<Character, Integer> map = new HashMap<>();
		for (int indx = 0; indx < str.length(); indx++) {
			if (map.containsKey(str.charAt(indx)))
				map.put(str.charAt(indx), map.get(str.charAt(indx)) + 1);
			else
				map.put(str.charAt(indx), 1);
		}
		int oddCount = 0;
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			if (entry.getValue() % 2 != 0)
				oddCount++;
		}
		if (oddCount <= 1)
			return true;
		return false;
	}
}
