package list;

public class MergedList {

	private Node head;

	static class Node {
		int data;
		Node next;

		Node (int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static Node find(MergedList list1, MergedList list2) {
		// Make list1 circular
		Node currentNode1 = list1.head;
		int i = 0;
		while (currentNode1.next != null) {
			currentNode1 = currentNode1.next;
			++i;
		}
		currentNode1.next = list1.head;
		// Traverse list2 as much as the size of list1
		Node currentNode2 = list2.head;
		int j = 0;
		while (currentNode2 != null && j <= i) {
			currentNode2 = currentNode2.next;
			++j;
		}
		if (currentNode2 == null) {
			return currentNode2;
		}
		Node currentNode3 = list2.head;
		while (currentNode3 != null) {
			if (currentNode3.next.data == currentNode2.next.data) {
				return currentNode3.next;
			} else {
				currentNode2=currentNode2.next;
				currentNode3=currentNode3.next;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		MergedList list1 = new MergedList();
		Node node_1 = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);
		Node node_5 = new Node(5);
		Node node_6 = new Node(6);
		list1.head = node_1;
		list1.head.next = node_2;
		list1.head.next.next = node_3;
		list1.head.next.next.next = node_4;
		list1.head.next.next.next.next = node_5;
		MergedList list2 = new MergedList();
		list2.head = node_6;
		list2.head.next = node_4;
		list2.head.next.next = node_5;
		System.out.println(find(list1, list2).data);
	}

}