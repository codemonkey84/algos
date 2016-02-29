/**
 * 
 */
package list;

/**
 * @author anmishra
 * Single-linked list
 *
 */
class LinkedList {

	private int size;
	private Node startNode;
	private Node endNode;

	int size() {
		return this.size;
	}

	Object get(int indx) {
		if (indx >= size) {
			return null;
		}
		if (indx == 0) {
			return this.startNode.getData();
		} else if (indx == size - 1) {
			return this.endNode.getData();
		} else {
			Node currentNode = this.startNode;
			for (int i = 0; i < indx; i++) {
				if (currentNode != null) {
					currentNode = currentNode.getNext();
				}				
			}
			return currentNode.getData();
		}
	}

	void add(Object o) {
		Node newNode = new Node();
		newNode.setData(o);
		if (this.startNode == null) {
			this.startNode = newNode;
		} else if (this.endNode == null) {
			this.endNode = newNode;
			this.startNode.setNext(endNode);
		} else {
			this.endNode.setNext(newNode);
			this.endNode = newNode;
		}
		++size;
	}

	boolean remove(int indx) {
		if (indx >= size) {
			return false;
		} else if (indx == 0) {
			Node first = this.startNode.getNext();
			this.startNode = first;
			--size;
			return true;
		} else {
			Node currentNode = this.startNode;
			Node prevNode = null;
			for (int i = 0; i < indx; i++) {
				if (i == indx - 1) {
					prevNode = currentNode;
				}
				currentNode = currentNode.getNext();
			}
			if (prevNode != null) {
				prevNode.setNext(currentNode.getNext());
			}
			--size;
			return true;
		}
	}
	
	boolean removeNode(Node node) {
		Node next = node.getNext();
		if (next == null) {
			return false;
		} else {
			node = next;
			return true;
		}
	}
	
	public String toString() {
		Node currentNode = this.startNode;
		StringBuffer sb = new StringBuffer();
		if (currentNode.getData() != null) {
			sb.append(currentNode.getData().toString());
		}
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			if (currentNode.getData() != null) {
				sb.append(currentNode.getData().toString());
			}
		}
		return sb.toString();
	}
}

class Node {

	private Object data;
	private Node next;

	void setData(Object data) {
		this.data = data;
	}

	void setNext(Node next) {
		this.next = next;
	}

	Object getData() {
		return this.data;
	}

	Node getNext() {
		return this.next;
	}
}