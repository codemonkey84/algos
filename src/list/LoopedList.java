package list;

public class LoopedList {

	static class Node {
		private int data;
		private Node next;

		Node (int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	private static Node detect(LoopedList list) {
		Node ptr1 = list.head;
		Node ptr2 = list.head;
		int i = 0, j = 0;
		while (ptr2 != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if (ptr1 == ptr2) {
				break;
			}
		}
		if (ptr2 != null) {
			Node ptr3 = list.head;
			while (ptr2 != ptr3) {
				ptr2 = ptr2.next;
				ptr3 = ptr3.next;
			}
		}
		return ptr2;
	}


	public static void main(String[] args) {
		LoopedList list = new LoopedList();
		Node node_1 = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);
		Node node_5 = new Node(5);
		list.head = node_1;
		list.head.next = node_2;
		list.head.next.next = node_3;
		list.head.next.next.next = node_4;
		list.head.next.next.next.next = node_5;
		list.head.next.next.next.next.next = node_2;
		System.out.println(detect(list).data);
	}
}