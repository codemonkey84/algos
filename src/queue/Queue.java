/**
 * 
 */
package queue;

/**
 * @author anmishra Sample queue (FIFO) implementation using Array
 */
public class Queue {

	private int capacity = 1;
	private Object[] objs = new Object[capacity];
	private int head;
	private int tail = -1;
	private int size;

	/**
	 * Enque into queue
	 * 
	 * @param elem
	 */
	public void enqueue(Object elem) {
		if (tail >= capacity - 1) {
			increaseCapacity();
		}
		objs[++tail] = elem;
		++size;
		display("enqueue");
	}
	
	/**
	 * Add another queue to this
	 * @param q
	 */
	public void addItems(Queue q) {
		while(q.peek() != null) {
			enqueue(q.dequeue());
		}
	}

	/**
	 * Dequeue from queue
	 * 
	 * @return
	 */
	public Object dequeue() {
		Object elem = null;
		if (size == 0 || head > tail) {
			throw new RuntimeException("No elem");
		} else {
			elem = objs[head];
			++head;
			--size;
		}
		display("dequeue");
		return elem;
	}
	
	public Object peek() {
		Object elem = null;
		if (tail >= 0 && head <= tail) {
			elem = objs[head];
		}
		return elem;
	}

	/**
	 * Returns size
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	private void increaseCapacity() {
		System.out.println("Oveflow. Increasing capacity..");
		capacity *= 2;
		Object[] objs = new Object[capacity * 2];
		System.arraycopy(this.objs, 0, objs, 0, capacity/2);
		this.objs = objs;
	}

	private void display(String op) {
		System.out.println("After " + op);
		for (int i = head; i <= tail; i++) {
			System.out.println(objs[i]);
		}
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		System.out.println("Size: "+queue.size());
		queue.enqueue(1);
		System.out.println("Size: "+queue.size());
		queue.enqueue(2);
		System.out.println("Size: "+queue.size());
		queue.enqueue(3);
		System.out.println("Size: "+queue.size());
		queue.enqueue(4);
		System.out.println("Size: "+queue.size());
		queue.enqueue(5);
		System.out.println("Size: "+queue.size());
		Queue q2 = new Queue();
		q2.enqueue(6);
		q2.enqueue(7);
//		queue.addItems(q2);
		System.out.println("Size: "+queue.size());
		System.out.println("Dequeued: "+queue.dequeue());
		System.out.println("Size: "+queue.size());
		System.out.println("Dequeued: "+queue.dequeue());
		System.out.println("Size: "+queue.size());
		System.out.println("Dequeued: "+queue.dequeue());
		System.out.println("Size: "+queue.size());
		System.out.println("Dequeued: "+queue.dequeue());
		System.out.println("Size: "+queue.size());
		System.out.println("Dequeued: "+queue.dequeue());
		System.out.println("Size: "+queue.size());
	}
}
