import java.util.NoSuchElementException;

public class DLLStack<E> implements Stack<E> {

	private DoublyLinkedList<E> myList;
	
	public DLLStack() {
		myList = new DoublyLinkedList<E>();
	}
	@Override
	public void push(E val) {
		// adapt the addFirst method into the push method
		myList.addFirst(val);
	}

	@Override
	public E pop() {
		// adapt the removeFirst method into the pop method
		return myList.removeFirst();
	}
	@Override
	public E top() {
		if (myList.isEmpty()) {
			throw new NoSuchElementException();
		}
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

