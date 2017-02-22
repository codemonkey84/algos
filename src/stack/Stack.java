/**
 * 
 */
package stack;

/**
 * @author anmishra Simple stack (LIFO) implemented using array
 */
public class Stack {
	
	private int tail = -1;
	private int size;
	private int capacity = 16;
	private Object[] objs = new Object[capacity];
	
	/**
	 * Push elem to the top of the stack
	 * @param obj
	 */
	public void push(Object obj) {
		if (tail >= capacity - 1) {
			throw new RuntimeException("Stack overflow");
		}
		objs[++tail] = obj;
		++size;
		display("push");
	}
	
	/**
	 * Pops out elem from the top of the stack
	 * @return
	 */
	public Object pop() {
		Object elem = null;
		if (size == 0) {
			throw new RuntimeException("No elem");
		}
		elem = objs[tail];
		--tail;
		--size;
		display("pop");
		return elem;
	}
	
	/**
	 * Peeks elem from the top of the stack, but soesn't remove them
	 * @return
	 */
	public Object peek() {
		Object elem = null;
		if (size > 0) {
			elem = objs[tail];
		}
		return elem;
	}
	
	/**
	 * Return size of the stack
	 * @return
	 */
	public int size() {
		return size;
	}
	
	private void display(String op) {
		System.out.println("After "+op);
		for (int i = 0; i <= tail; i++) {
			System.out.println(objs[i]);
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		System.out.println("Size: "+stack.size());
		stack.push(2);
		System.out.println("Size: "+stack.size());
		stack.push(3);
		System.out.println("Size: "+stack.size());
		stack.push(4);
		System.out.println("Size: "+stack.size());
		stack.push(5);
		System.out.println("Size: "+stack.size());
		System.out.println("Popped: "+stack.pop());
		System.out.println("Size: "+stack.size());
		System.out.println("Popped: "+stack.pop());
		System.out.println("Size: "+stack.size());
		System.out.println("Popped: "+stack.pop());
		System.out.println("Size: "+stack.size());
		System.out.println("Popped: "+stack.pop());
		System.out.println("Size: "+stack.size());
		System.out.println("Popped: "+stack.pop());
		System.out.println("Size: "+stack.size());
	}

}
