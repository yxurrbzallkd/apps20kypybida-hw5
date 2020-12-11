package ua.edu.ucu.iterator;
import java.util.ArrayList;
import java.util.Iterator;


public class Queue<E> implements Iterable<E> {
	class Node {
		public E item;
		public Node next;
		public Node previous;
		public Node(E item, Node next, Node previous) {
			this.next = next;
			this.item = item;
			this.previous = previous;
		}

		public Node() {
		}
	}
	private Node head;
	private Node tail;

	public Queue() {
		this.tail = new Node();
		this.head = new Node();
		this.tail.previous = this.head;
		this.head.next = this.tail;
	}

	public void enqueue(E item) {
		Node newnode = new Node(item, this.tail, this.tail.previous);
		this.tail.previous.next = newnode;
		this.tail.previous = newnode;
	}

	public boolean isEmpty () {
		return this.head.next == this.tail;
	}

	public E dequeue() {
		E item = this.head.next.item;
		this.head.next = this.head.next.next;
		this.head.next.previous = this.head;
		return item;
	}

	public int length() {
		Node n = this.head.next;
		int length = 0;
		while (n != this.tail) {
			length++;
			n = n.next;
		}
		return length;
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator<E>(this);
	}
}