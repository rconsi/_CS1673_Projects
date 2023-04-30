public class DoublyLinkedList<E> {
    //These are the sentinel nodes which always exist
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public DoublyLinkedList() {
		
		this.size = 0;
		this.head = new Node<E>(null,null,null);
		this.tail = new Node<E>(null,null,null);
		this.head.setNext( tail );
		this.tail.setPrev( head );
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	public int search(E val) {
		Node<E> current = head;
		int index = 0;
		while (current != null) {
			if(current.getMyVal() == val) {
				return -1;
			}
			current = current.getNext();
			index++;
		}
		return index;
	}
	
	@Override
	public String toString() {
		String result = "";
		Node<E> current = head.getNext();
		while (current != tail) {
			result = result + current.toString() + " ";
			current = current.getNext();
		}
		return " [ " + result + "] ";
	}
	
	public void addFirst(E val) {
		//create new node to hold val
		Node<E> node = new Node<E>(head,val,head.getNext());
		head.getNext().setPrev(node);
		this.head.setNext(node);
		size++;
		
	}
	public void addLast(E val) {
		Node<E> node = new Node<E>(tail.getPrev(),val,tail);
		tail.getPrev().setNext( node );
		tail.setPrev( node );
		size++;
	}
	public E getFromIndex(int i) {
		if (i < 0) {
			throw new IndexOutOfBoundsException(" Index is Negative");
		}
		if (i >= this.size ) {
			throw new IndexOutOfBoundsException(" Index is : " + i);
		}
		
		Node<E> current = this.head.getNext();
		int temp = 0;
		while (temp != i) {
			current = current.getNext();
			temp++;
		}
		return current.getMyVal();
	}
	public E removeFirst() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Cannot remove from an empty list!");
		}
		E result = head.getNext().getMyVal();
		head.setNext(head.getNext().getNext());
		head.getNext().setPrev( head );
		size--;
		return result;
	}
	public E removeLast() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Cannot remove from an empty list!");
		}
		E result = tail.getPrev().getMyVal();
		tail.setPrev(tail.getPrev().getPrev());
		tail.getPrev().setPrev( head );
		size--;
		return result;
	}
}
