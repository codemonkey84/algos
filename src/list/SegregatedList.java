package list;

class SegregatedList {
    
    static class Node {
        int data;
        Node next;
        
        Node (int d) {
            data = d;
        }
    }
    
    Node head;
    
    static SegregatedList copy(SegregatedList list) {
        Node current = list.head;
        Node copy = new Node(current.data);
        SegregatedList copiedList = new SegregatedList();
        copiedList.head = copy;
        while (current.next != null) {
            System.out.println("Copying "+current.next.data);
            copy.next = current.next ;
            current = current.next;
            copy = copy.next;
        }
        return copiedList;
    }

    public static void main(String[] args) {
        SegregatedList list = new SegregatedList();
        list.head = new Node(17);
        list.head.next = new Node(15); 
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(9);
        /*list.head.next.next.next.next = new Node(2);
        list.head.next.next.next.next.next = new Node(4);
        list.head.next.next.next.next.next.next = new Node(6);*/
        SegregatedList currentOdd = copy(list);
        Node head = currentOdd.head;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}