package list;
// Add any extra import statements you may need here


public class SubsetReverser {
  
  class Node {
    int data;
    Node next;
    Node(int x) {
      data = x;
      next = null;
    }
  }

  // Add any helper functions you may need here
  

  Node reverse(Node head) {
    if (null == head || null == head.next)
      return head;
    Node prevNode = head;
    Node currNode = head.next;
    
    // References to track starting boundary of the segment
    Node firstEvenNode = null, prevOfFirstEvenNode = null;
    while (null != currNode) {
      Node nextNode = currNode.next;
      // If previous node is odd and current node is even we have our boundary 
      if (0 != prevNode.data % 2 && 0 == currNode.data % 2) {
        prevOfFirstEvenNode = prevNode;
        firstEvenNode = currNode;
      }
      /** 
       * If both are even, reverse the relationship, also take care of the
       * boundary if these are the first even nodes
       */
      else if (0 == prevNode.data % 2 && 0 == currNode.data % 2) {
        if (null == firstEvenNode)
          firstEvenNode = prevNode;
        // reverse prev and curr node
        currNode.next = prevNode;
        
        /**
         *  If next node is odd define the finishing boundary, i.e. link the
         *  next node with the first even node, and set the current node as next
         *  to the previous to the first even node (if any) or head
         */
        if (null == nextNode || 0 != nextNode.data % 2) {
          if (null != prevOfFirstEvenNode)
            prevOfFirstEvenNode.next = currNode;
          else
            head = currNode;
          firstEvenNode.next = nextNode;
        }
      }
      prevNode = currNode;
      currNode = nextNode;
    }
    return head;
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;

  void printLinkedList(Node head) {
    System.out.print("[");
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
      if (head != null)
        System.out.print(" ");
    }
    System.out.print("]");
  }
  void check(Node expectedHead, Node outputHead) {
    boolean result = true;
    Node tempExpectedHead = expectedHead;
    Node tempOutputHead = outputHead;
    while (expectedHead != null && outputHead != null) {
      result &= (expectedHead.data == outputHead.data);
      expectedHead = expectedHead.next;
      outputHead = outputHead.next;
    }
    if (!(expectedHead == null && outputHead == null)) result = false;

    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    } else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printLinkedList(tempExpectedHead); 
      System.out.print(" Your output: ");
      printLinkedList(tempOutputHead);
      System.out.println();
    }
    test_case_number++;
  }
  Node createLinkedList(int[] arr) {
    Node head = null;
    Node tempHead = head;
    for (int v : arr) {
      if (head == null) {
        head = new Node(v);
        tempHead = head;
      } else {
        head.next = new Node(v);
        head = head.next;
      }
    }
    return tempHead;
  }
  
  public void run() {
  
    int[] arr_1 = {1, 2, 8, 9, 12, 16};
    int[] expected1 = {1, 8, 2, 9, 16, 12};
    Node head_1 = createLinkedList(arr_1);
    Node expected_1 = createLinkedList(expected1);
    Node output_1 = reverse(head_1);
    check(expected_1, output_1);

    int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
    int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
    Node head_2 = createLinkedList(arr_2);
    Node expected_2 = createLinkedList(expected2);
    Node output_2 = reverse(head_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    int[] arr_3 = {1, 2, 18, 24, 3, 5, 7, 9, 6, 12, 11};
    int[] expected3 = {1, 24, 18, 2, 3, 5, 7, 9, 12, 6, 11};
    Node head_3 = createLinkedList(arr_3);
    Node expected_3 = createLinkedList(expected3);
    Node output_3 = reverse(head_3);
    check(expected_3, output_3);
  }
  
  public static void main(String[] args) {
    new SubsetReverser().run();
  }
}