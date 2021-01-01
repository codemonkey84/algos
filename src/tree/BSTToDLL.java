package tree;

/**
 * Modify BST to Doubly Linked List in place
 *
 * @author amishra
 *
 */
public class BSTToDLL {

	static class Node {
		private int data;
		private Node left;
		private Node right;
		// private Node parent;

		Node(int d) {
			data = d;
		}
	}

	private Node root;
	private Node prev;
	private Node head;

	/**
	 * In-order traversal starting from root node:
	 *
	 * Recursively perform step# 1 & 4 until current node is null
	 *
	 * 1. left subtree of current node is getting added
	 * 2. current node and previous node creating DLL relation
	 * 3. Set current node as previous node for next iteration
	 * 4. right subtree of current node is getting added
	 *
	 * @param node
	 */
	private void convert(Node node) {
		if (node == null)
			return;

		convert(node.left);

		if (prev != null) {
			prev.right = node;
			node.left = prev;
		} else
			head = node;

		prev = node;
		
		convert(node.right);
	}


	public static void main(String[] args) {
		Node node_1 = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);
		Node node_5 = new Node(5);
		Node node_6 = new Node(6);
		Node node_7 = new Node(7);
		Node node_8 = new Node(8);
		Node node_9 = new Node(9);
		Node node_10 = new Node(10);
		Node node_11 = new Node(11);
		Node node_12 = new Node(12);
		Node node_13 = new Node(13);
		Node node_14 = new Node(14);
		Node node_15 = new Node(15);

		node_1.left = node_2;
		node_1.right = node_3;
		node_2.left = node_4;
		node_2.right = node_5;
		node_3.left = node_6;
		node_3.right = node_7;
		node_4.left = node_8;
		node_4.right = node_9;
		node_5.left = node_10;
		node_5.right = node_11;
		node_6.left = node_12;
		node_6.right = node_13;
		node_7.left = node_14;
		node_7.right = node_15;

		BSTToDLL bst = new BSTToDLL();
		bst.root = node_1;
		bst.convert(node_1);

		Node current = bst.head;
		while (current != null) {
			System.out.println(current.data);
			current = current.right;
		}

	}
}