/**
 * 
 */
package tree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author amishra
 *
 */
public class IntBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);
		node4.left = node7;
		node4.right = node9;
		
		Node node10 = new Node(10);
		Node node2 = new Node(2);
		node7.left = node10;
		node7.right = node2;

		Node node6 = new Node(6);
		node9.right = node6;

		Node node5 = new Node(5);
		node2.right = node5;

		Node node3 = new Node(3);
		node5.left = node3;
		
		displayAverage(node4);
		int[] route = new int[1000];
		List<List<Integer>> lists = new LinkedList<>();
		findRoute(node4, route, 0, lists);
		System.out.println(lists);
	}
	
	
	
	private static void findRoute(Node root, int[] route, int indx, List<List<Integer>> lists) {
 
		if (null == root)
			return;
		
		route[indx++] = root.data;
		
		// Base case - print once target child node is reached
		if (null == root.left && null == root.right) {
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < indx; i++) {
				list.add(route[i]);
			}
			if (!list.isEmpty())
				lists.add(list);
			return;
		}
		
		findRoute(root.left, route, indx, lists);
		findRoute(root.right, route, indx, lists);
		
	}

	private static void displayAverage(Node node) {
		if (null != node) {
			Map<Integer, List<Integer>> group = new LinkedHashMap<>();
			List<Integer> elems = new LinkedList<>();
			elems.add(node.data);
			group.put(0, elems);
			groupBydepth(node, 1, group);
			group.entrySet().forEach(entry -> {
				System.out.println(entry.getValue().stream().mapToInt(Integer::intValue).average());
			});
		}
	}
	private static void groupBydepth(Node node, int depth, Map<Integer, List<Integer>> group) {
		List<Integer> elems = null;
		if (null != node) {
			elems = new LinkedList<>();
			if (null != node.left)
				elems.add(node.left.data);
			if (null != node.right)
				elems.add(node.right.data);
			if (group.containsKey(depth))
				group.get(depth++).addAll(elems);
			else
				group.put(depth++, elems);
			groupBydepth(node.left, depth, group);
			groupBydepth(node.right, depth, group);
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node (int data) {
			this.data = data;
		}
	}
}

