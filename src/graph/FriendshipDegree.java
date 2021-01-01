/**
 * 
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author amishra
 *
 */
public class FriendshipDegree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FriendshipDegree().findDistance(new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}}, 0, 1));
		System.out.println(new FriendshipDegree().findDistance(new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}}, 1, 2));
		System.out.println(new FriendshipDegree().findDistance(new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}}, 0, 2));
		System.out.println(new FriendshipDegree().findDistance(new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}}, 0, 0));
	}

	private int findDistance(int[][] friends, int userA, int userB) {

		boolean [] visited = new boolean[friends.length];
		int [] degree = new int[friends.length];
		for (int indx = 0; indx < degree.length; indx++)
			degree[indx] = Integer.MAX_VALUE;

		visited[userA] = true;
		degree[userA] = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(userA);

		while (!queue.isEmpty()) {
			int user = queue.poll();
			for (int indx = 0; indx < friends.length; indx++) {
				if (!visited[indx] && friends[user][indx] == 1
						&& degree[indx] > degree[user] + friends[user][indx]) {
					visited[indx] = true;
					queue.add(indx);
					degree[indx] = degree[user] + friends[user][indx];
					System.out.println("degree["+indx+"]: "+ degree[indx]);
				}
			}
		}
		return degree[userB];
	}
}
