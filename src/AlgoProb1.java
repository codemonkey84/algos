import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//		try (Scanner scanner = new Scanner(System.in)) {
//			System.out.print("Please enter the length of the array : ");
//			int len = scanner.nextInt();
//			int[] arr = new int[len];
//			for (int i = 0; i < len; i++) {
//				System.out.println();
//				System.out.print("Please enter the element at position " + (i + 1) + " : ");
//				arr[i] = scanner.nextInt();
//			}
//			System.out.println();
//			System.out.print("Please enter how many 0s to be flipped to 1: ");
//			int k = scanner.nextInt();
//			System.out.println(solve(arr, k));
//		}
//		Long a =null;
//	    System.out.println(0l == a);
	    String rx = "\\d{5}(-\\d{4})";
	    Pattern p = Pattern.compile(rx);
	    String singleLineAddress = "test54321-5432test12345-1234abc56789-5678xyx4abc56789-5678";
	     
	    Matcher m = p.matcher(singleLineAddress);
	    while (m.find()) {
	    	String postalCode = m.group().split("-")[0];
	    	singleLineAddress = singleLineAddress.replaceAll(m.group(), postalCode);
	    }
	    System.out.println(singleLineAddress);
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
