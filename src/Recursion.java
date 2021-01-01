import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author amishra
 *
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Recursion().sum(10));
		System.out.println(new Recursion().factorial(10));
		System.out.println(new Recursion().fib(13));
		Queue<Integer> queue = new LinkedList<>();
		queue.add(2);
		queue.add(56);
		queue.add(7);
		System.out.println(new Recursion().product(queue));
		System.out.println("Madam".substring(0, "Madam".length() - 1));
		System.out.println(new Recursion().isPalindrome("kayaka"));
	}

	/**
	 * Calculate sum from 1 to n
	 *
	 * @param num
	 * @return
	 */
	private int sum(int num) {
		if (num <= 0)
			return 0;
		if (num == 1)
			return num;
		return num + sum(num - 1);
	}
	
	private int factorial(int num) {
		if (num <= 1)
			return 1;
		return num * factorial(num - 1);
	}
	
	private int fib(int num) {
		if (num <= 1)
			return num;
		return fib(num - 1) + fib(num - 2);
	}
	
	private int product(Queue<Integer> queue) {
		if (queue.size() == 0)
			return 1;
		return queue.poll() * product(queue);
	}
	
	private boolean isPalindrome(String str) {
		String rev = reverse(str);
		return str.equalsIgnoreCase(rev);
	}
	
	private String reverse(String str) {
		if (0 == str.length())
			return "";
		return str.substring(str.length() - 1).concat(reverse(str.substring(0, str.length() - 1)));
	}
}
