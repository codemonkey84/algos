package list;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class IntLinkedList {

	IntNode head;
	IntNode tail;
	
	void add (int elem) {
		if (null != tail) {
			tail.next = new IntNode(elem);
			tail = tail.next;
		}
		else if (null == head) {
			head = new IntNode(elem);
			tail = head;
		}
		else {
			IntNode currentNode = this.head;
			while (null != currentNode.next) {
				currentNode = currentNode.next;
			}
			currentNode.next = new IntNode(elem);
			tail = currentNode.next;
		}
	}

	int get(int indx) {
		IntNode currNode = head;
		for (int i = 0; null != currNode; i++) {
			if (i == indx) {
				return currNode.val;
			}
			currNode = currNode.next;
		}
		throw new NullPointerException("Index not found");
	}

	void remove (int indx) {
		IntNode currentNode = head;
		IntNode prevNode = null;
		for (int i = 0; null != currentNode; i++) {
			if (i == indx) {
				if (null == prevNode)
					head = currentNode.next;
				else {
					prevNode.next = currentNode.next;
				}
				return;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
	}

	void reverse() {
		IntNode currNode = head;
		this.tail = head;
		IntNode prevNode = null;
		while (null != currNode) {
			IntNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		this.head = prevNode;
	}

	void dedup() {
		IntNode currNode = head;
		IntNode prevNode = null;
		HashSet<Integer> values = new HashSet<>();
		while (null != currNode) {
			if(!values.add(currNode.val)) {
				prevNode.next = currNode.next;
				currNode = prevNode.next;
			}
			else {
				prevNode = currNode;
				currNode = currNode.next;
			}
		}
	}

	boolean isCircular() {
		IntNode currNode = head;
		do {
			if (null != currNode)
				currNode = currNode.next;
		} while (null != currNode && currNode != head);
		return currNode == head;
	}

	boolean isLooped() {
		IntNode currNode = head;
        Set<IntNode> nodes = new HashSet<>();
        while (null != currNode && nodes.add(currNode)) {
            currNode = currNode.next;
        }
        return null != currNode;
	}

	void convertToCircular() {
		IntNode currNode = head;
		while (null != currNode.next)
			currNode = currNode.next;;
		currNode.next = head;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the list : ");
			String str = scanner.nextLine();
			IntLinkedList list = new IntLinkedList();
			for (int i = 0; i < str.length(); i++) {
				list.add(Character.getNumericValue(str.charAt(i)));
			}
			list.add(0);
			list.convertToCircular();
//			list.remove(2);
//			list.reverse();
//			list.dedup();
//			list.tail.next = list.head;
			System.out.println(list.isCircular());
			for (int i = 0; i < str.length() + 1; i++) {
				System.out.println("Elem at index "+ i + ": "+list.get(i));
			}
		}
	}
}

class IntNode {

	IntNode next;
	int val;
	
	IntNode (int val) {
		this.val = val;
		this.next = null;
	}
}