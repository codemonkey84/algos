/**
 * 
 */
package tree;

import java.util.Scanner;

import queue.Queue;

/**
 * @author lenovo Simple Binary Search Tree (BST) implementation
 */
public class BST<E extends Comparable> {

	private Node<E> root;

	/**
	 * Insert data into BST
	 * 
	 * @param data
	 * @return Node<E>
	 */
	public Node<E> insert(E data) {
		if (data != null) {
			root = insertRecursively(root, data);
		}
		return root;
	}

	/**
	 * Search for a node
	 * 
	 * @param data
	 * @return Node<E>
	 */
	public Node<E> search(E data) {
		Node<E> foundNode = null;
		if (data != null) {
			foundNode = bfs(root, data);
		}
		return foundNode;
	}

	/**
	 * Prune a node lesser than given sum of any path the node belongs to
	 *
	 * @param data
	 * @return Node<E>
	 */
	public Node<E> prune(int k, int sum) {
		Node current = root;
		if (current == null)
			return current;

		int lsum += current.data;
		int rsum = lsum;

		current.left = prune(current.left, k, lsum);
		current.right = prune(current.right, k, rsum);

		if ((lsum > rsum && lsum < k) || (rsum >= lsum && rsum < k) {
			current = null;
		}
		return current;
	}

	/**
	 * Delete a node
	 * 
	 * @param data
	 * @return Node<E>
	 */
	public Node<E> delete(E data) {
		/*if (search(data) != null && root != null) {
			root = deleteRecursively(root, data);
		}*/
		Node current = root;
		Node nodeToBeDeleted = null;
		Node parent = current;
		boolean isLeftChild = true;
		while (current != null) {
			if (data.compareTo(current.getData()) < 0 ) {
				parent = current;
				current = current.getLeft();
				isLeftChild = true;
			} else if (data.compareTo(current.getData()) > 0) {
				parent = current;
				current = current.getRight();
				isLeftChild = false;
			} else {
				nodeToBeDeleted = current;
				break;
			}
		}
		if (nodeToBeDeleted == root || nodeToBeDeleted == null) {
			return null;
		}
		if (nodeToBeDeleted != null) {
			if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
				if (isLeftChild) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			} else if (nodeToBeDeleted.getLeft() == null) {
				if (isLeftChild) {
					parent.setLeft(nodeToBeDeleted.getRight());
				} else {
					parent.setRight(nodeToBeDeleted.getRight());
				}
			} else if (nodeToBeDeleted.getLeft() == null) {
				if (isLeftChild) {
					parent.setLeft(nodeToBeDeleted.getRight());
				} else {
					parent.setRight(nodeToBeDeleted.getLeft());
				}
			} else {
				Node successor = successor(nodeToBeDeleted);
				if (isLeftChild) {
					parent.setLeft(successor);
				} else {
					parent.setRight(successor);
				}
			}
		}

		return root;
	}

	private Node successor(Node node) {
		Node successor = node.getRight();
		Node successorParent = node;
		while (successor.getLeft() != null) {
			successorParent = successor;
			successor = successor.getLeft();
		}
		if (successor.getRight() != null) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
			successor.setLeft(node.getLeft());
		}
		return successor;
	}

	private Node<E> deleteRecursively(Node<E> node, E data) {
		if (data.compareTo(node.getData()) < 0) {
			node.setLeft(deleteRecursively(node.getLeft(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRight(deleteRecursively(node.getRight(), data));
		} else {
			if (node.getLeft() == null && node.getRight() == null) {
				return null;
			} else if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				Node<E> right = node.getRight();
				while (right.getLeft() != null) {
					right = right.getLeft();
				}
				right.setLeft(node.getLeft());
				return node.getRight();
			}
		}
		return node;
	}

	/**
	 * Check if the BST is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return countNodes() == 0;
	}

	/**
	 * Count all the nodes
	 * 
	 * @return int
	 */
	public int countNodes() {
		return countRecursively(root);
	}

	/**
	 * Pre-order traversal
	 */
	public void preorder() {

		preorder(root);
	}

	/**
	 * Post-order traversal
	 */
	public void postorder() {
		postorder(root);
	}

	/**
	 * In-order traversal
	 */
	public void inorder() {
		inorder(root);
	}

	private Node<E> dfs(Node<E> node, E data) {
		if (node == null) {
			return node;
		}
		if (data.compareTo(node.getData()) < 0) {
			return dfs(node.getLeft(), data);
		} else if (data.compareTo(node.getData()) > 0) {
			return dfs(node.getRight(), data);
		} else {
			return node;
		}
	}
	
	private Node<E> bfs(Node<E> node, E data) {
		if (node == null) {
			return node;
		}
		Node<E> foundNode = null;
		Queue queue = new Queue();
		queue.enqueue(node);
		while(queue.size() > 0) {
			Node<E> elem = (Node<E>)queue.dequeue();
			if (data.compareTo(elem.getData()) == 0) {
				foundNode = elem;
				break;
			}
			if(elem.getLeft() != null) {
				queue.enqueue(elem.getLeft());
			}
			if (elem.getRight() != null) {
				queue.enqueue(elem.getRight());
			}
		}
		return foundNode;
	}

	private void preorder(Node<E> node) {
		if (node != null) {
			System.out.println(node.getData());
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}

	private void postorder(Node<E> node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.println(node.getData());
		}
	}

	private void inorder(Node<E> node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.println(node.getData());
			inorder(node.getRight());
		}
	}

	private int countRecursively(Node<E> node) {
		int count = 0;
		if (node != null) {
			++count;
			count += countRecursively(node.getLeft());
			count += countRecursively(node.getRight());
		}
		return count;
	}

	private Node<E> insertRecursively(Node<E> node, E data) {
		if (node == null) {
			node = new Node<>(data);
		} else if (data.compareTo(node.getData()) <= 0) {
			node.setLeft(insertRecursively(node.getLeft(), data));
		} else {
			node.setRight(insertRecursively(node.getRight(), data));
		}
		return node;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of BST */
		BST<Integer> bst = new BST<>();
		System.out.println("Binary Search Tree Test\n");
		char ch;
		/* Perform tree operations */
		do {
			System.out.println("\nBinary Search Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. delete");
			System.out.println("3. search");
			System.out.println("4. count nodes");
			System.out.println("5. check empty");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				bst.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to delete");
				bst.delete(scan.nextInt());
				break;
			case 3:
				System.out.println("Enter integer element to search");
				System.out.println("Search result : "
						+ bst.search(scan.nextInt()));
				break;
			case 4:
				System.out.println("Nodes = " + bst.countNodes());
				break;
			case 5:
				System.out.println("Empty status = " + bst.isEmpty());
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display tree */
			System.out.print("\nPost order : ");
			bst.postorder();
			System.out.print("\nPre order : ");
			bst.preorder();
			System.out.print("\nIn order : ");
			bst.inorder();

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		scan.close();
	}
}

class Node<E extends Comparable> {

	private E data;
	private Node<E> left;
	private Node<E> right;

	Node(E data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public Node<E> getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Node<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node<E> getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node<E> right) {
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [data=").append(data).append("]");
		return builder.toString();
	}

}
