import java.util.*;
public class Exercise24_5 {
	public static void main(String[] args) {
		String[] list = {"Steve", "John"};
		GenericQueue<String> queue = new GenericQueue<String>(list);
		System.out.println("Queue: " + queue);
		queue.enqueue("Steven");
		System.out.println("Queue: " + queue);
		System.out.println(queue.dequeue() + " was removed from the queue");
		System.out.println("Queue: " + queue);
	}
}
class GenericQueue<E> extends LinkedList<E> {
	GenericQueue() {
		
	}
	GenericQueue(E[] list) {
		for(E element: list) {
			addLast(element);
		}
	}
	public void enqueue(E e) {
		add(e);
		System.out.println(e + " was added to the queue");
	}
	public E dequeue() {
		return this.removeFirst();
	}
}