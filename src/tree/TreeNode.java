/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author anmishra Simple tree implementation using linked list
 */

public class TreeNode<E> {

	private E data;
	private TreeNode<E> parent;
	private List<TreeNode<E>> children = new LinkedList<>();

	public TreeNode(E data) {
		this.data = data;
	}

	public TreeNode(E data, TreeNode<E> parent) {
		this.parent = parent;
		parent.children.add(this);
		this.data = data;
	}

	/**
	 * Retrieve node data
	 * 
	 * @return E
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set node data
	 * 
	 * @param data
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * set parent node
	 * 
	 * @param parent
	 */
	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
		parent.children.add(this);
	}

	/**
	 * Remove parent node
	 */
	public void removeParent() {
		this.parent = null;
	}

	/**
	 * Retrieve parent node
	 * 
	 * @return TreeNode<E>
	 */
	public TreeNode<E> getParent() {
		return this.parent;
	}

	/**
	 * Add child node
	 * 
	 * @param child
	 */
	public void addChild(TreeNode<E> child) {
		this.children.add(child);
	}

	/**
	 * Remove child node
	 * 
	 * @param child
	 */
	public void removeChild(TreeNode<E> child) {
		this.children.remove(child);
	}

	/**
	 * Retrieve all children
	 * 
	 * @return
	 */
	public List<TreeNode<E>> getChildren() {
		return this.children;
	}

	/**
	 * Checks if this node is a leaf node
	 * 
	 * @return boolean
	 */
	public boolean isLeaf() {
		return this.children.size() == 0;
	}

	/**
	 * Checks if this node is a root node
	 * 
	 * @return boolean
	 */
	public boolean isRoot() {
		return this.parent == null;
	}

	private void display() {
		System.out.println("Parent: " + this.getData());
		displayChildren(this);
	}

	private void displayChildren(TreeNode<E> parent) {
		for (TreeNode<E> child : parent.getChildren()) {
			System.out.println("Child: " + child.getData()+" of "+parent.getData());
			displayChildren(child);
		}
	}

	public static void main(String[] args) {
		TreeNode<String> parentNode = new TreeNode<String>("Parent");
		TreeNode<String> childNode1 = new TreeNode<String>("Child 1", parentNode);
		TreeNode<String> childNode2 = new TreeNode<String>("Child 2");

		childNode2.setParent(parentNode);

		new TreeNode<String>("Grandchild of parentNode. Child of childNode1", childNode1);
		parentNode.display();
	}

}
