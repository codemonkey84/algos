/**
 * 
 */
package array;

/**
 * @author amishra
 *
 */
public class TargetSum {

	/**
	 * Problem Statement
	 * =================
	 * You are given a list of non-negative integers, a1, a2, ..., an, and a
	 * target, S. Now you have 2 symbols + and -. For each integer, you should
	 * choose one from + and - as its new symbol. Find out how many ways to
	 * assign symbols to make sum of integers equal to target S.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TargetSum().findWays(new int[] {1,1,1,1,1}, 3));
		System.out.println(new TargetSum().findWays(new int[] {1,1,1}, 1));
		System.out.println(new TargetSum().findWays(new int[] {3, 1}, 2));
	}

	private int findSubset(int indx, int sum, int[] arr, int[][] dp) {
		if (sum == 0)
			return 1;
		if (indx > arr.length - 1)
			return 0;
		if (dp[sum][indx] != -1)
			return dp[sum][indx];
		int count1 = findSubset(indx + 1, sum - arr[indx], arr, dp);
		int count2 = findSubset(indx + 1, sum, arr, dp);
		dp[sum][indx] = count1 + count2;
		return count1 + count2;
	}
	
	private int findWays(int[] arr, int S) {
		int sum = 0;
		for (int indx = 0; indx < arr.length; indx++)
			sum += arr[indx];
		int subsetSum = (S + sum) / 2;
		if ((S + sum) % 2 != 0)
			return -1;
		else {
			int[][] dp = new int[sum][arr.length];
			for (int i = 0; i < dp.length; i++)
				for (int j = 0; j < arr.length; j++)
					dp[i][j] = -1;
			return findSubset(0, subsetSum, arr, dp);
		}
	}
	
}
