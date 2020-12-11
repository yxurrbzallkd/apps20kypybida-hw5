package ua.edu.ucu.iterator;
import java.util.Iterator;


public class QueueIterator<E> implements Iterator<E> {
	public Queue<E> q;

	public QueueIterator(Queue<E> q) {
		this.q = q;
	}
	@Override
	public boolean hasNext() {
		return !this.q.isEmpty();
	}
	@Override
	public E next() {
		return this.q.dequeue();
	}
	@Override
	public void remove() {
        throw new UnsupportedOperationException();
    }
}
