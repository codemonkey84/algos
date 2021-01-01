/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author anmishra Simple tree implementation using linked list
 */

public class TreeNodeTest<E> {

	private E data;
	private TreeNodeTest<E> parent;
	private List<TreeNodeTest<E>> children = new LinkedList<>();

	public TreeNodeTest(E data) {
		this.data = data;
	}

	public TreeNodeTest(E data, TreeNodeTest<E> parent) {
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
	public void setParent(TreeNodeTest<E> parent) {
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
	 * @return TreeNodeTest<E>
	 */
	public TreeNodeTest<E> getParent() {
		return this.parent;
	}

	/**
	 * Add child node
	 * 
	 * @param child
	 */
	public void addChild(TreeNodeTest<E> child) {
		this.children.add(child);
	}

	/**
	 * Remove child node
	 * 
	 * @param child
	 */
	public void removeChild(TreeNodeTest<E> child) {
		this.children.remove(child);
	}

	/**
	 * Retrieve all children
	 * 
	 * @return
	 */
	public List<TreeNodeTest<E>> getChildren() {
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

	private void displayChildren(TreeNodeTest<E> parent) {
		for (TreeNodeTest<E> child : parent.getChildren()) {
			System.out.println("Child: " + child.getData()+" of "+parent.getData());
			displayChildren(child);
		}
	}

	public static void main(String[] args) {
		TreeNodeTest<String> parentNode = new TreeNodeTest<String>("Parent");
		TreeNodeTest<String> childNode1 = new TreeNodeTest<String>("Child 1", parentNode);
		TreeNodeTest<String> childNode2 = new TreeNodeTest<String>("Child 2");

		childNode2.setParent(parentNode);

		new TreeNodeTest<String>("Grandchild of parentNode. Child of childNode1", childNode1);
		parentNode.display();
	}

}
