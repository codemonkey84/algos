package queue;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(42);
        queue.dequeue();
        queue.enqueue(14);
        queue.print();
        queue.enqueue(28);
        queue.print();
        queue.enqueue(60);
        queue.enqueue(78);
    }
    
    static class Queue {
        
        private Stack<Integer> enqueueStack;
        private Stack<Integer> dequeueStack;

        Queue () {
            enqueueStack = new Stack<>();
            dequeueStack = new Stack<>();
        }

        private void enqueue(int data) {
            enqueueStack.push(data);
        }

        private void dequeue() {
            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
            dequeueStack.pop();
        }
        
        private void print() {
        	if (enqueueStack.size() == 1)
        		System.out.println(enqueueStack.peek());
        	else {
        		while (!enqueueStack.isEmpty())
                    dequeueStack.push(enqueueStack.pop());
                System.out.println(dequeueStack.peek());
        	}
        }
    }
}
