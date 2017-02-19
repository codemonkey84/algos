package list;

public class DeleteFromList {

	static class Node {

		private int data;
		private Node next;

		Node (int d) {
			data = d;
		}
	}

	private Node head;

	static Node deleteAllOccurances(Node head, int x)
    {
        // Your code here
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
        	next = current.next;
            if (current.data == x) {
            	current = next;
            	if (prev != null)
            	prev.next = next;
            	else head = current;
            } else {
                prev = current;
                current = next;
            }
        }
        return head;
    }

    static Node deleteEveryKthNode(Node head, int k) {
    	if (k == 0) {
    		return head;
    	}
    	Node current = head;
    	Node prev = null;
    	Node next = null;
    	int i = 0;
    	while (current != null) {
    		next = current.next;
    		if (k == 1) {
    			current = next;
    			head = current;
    		} else if (((k == 2) && (i % k) == 1) || (k != 2 && i / (k-1) > 0 && i % (k-1) == 0)) {
    			current = next;
    			if (prev != null) {
    				prev.next = next;
    			} else
    				head = current;
    		} else {
    			prev = current;
    			current = next;
    		}
    		++i;
    	}
    	return head;
    }

    public static void main (String[] args) {
    	DeleteFromList list = new DeleteFromList();
    	list.head = new Node(2);
    	list.head.next = new Node(2);
    	list.head.next.next = new Node(1);
    	list.head.next.next.next = new Node(4);
    	list.head.next.next.next.next = new Node(4);
    	// Node head = deleteAllOccurances(list.head, 2);
    	Node head = deleteEveryKthNode(list.head, 2);
    	while (head != null) {
    		System.out.println(head.data);
    		head = head.next;
    	}
    }
}