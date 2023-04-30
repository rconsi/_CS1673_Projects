import java.util.NoSuchElementException;

public class DLLQueue<E> implements Queue<E> {
	private DoublyLinkedList<E> myList;
	@Override
	public void enqueue(E val) {
		myList.addLast(val);
	}
	@Override
	public E dequeue() {
		if (myList.isEmpty()) {
			throw new NoSuchElementException();
		}
		return myList.removeFirst();
	}

	@Override
	public E getFirst() {
		return myList.getFromIndex(0);
	}
	@Override
	public int size() {
		return myList.size();
	}

	@Override
	public boolean isEmpty() {
		return myList.isEmpty();
	}
}
