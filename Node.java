public class Node<E> {
    //instance variables to store references
	//	to the prev node in the list
	//	the value stored at this node to 
	//	the next node in the list
	private E myVal;
	private Node<E> next;
	private Node<E> prev;
	
	public Node(Node<E> prevVal, E val, Node<E> nextVal) {
		this.prev = prevVal;
		this.myVal = val;
		this.next = nextVal;
	}
	
	public E getMyVal() {
		return myVal;
	}
	public void setMyVal(E myVal) {
		this.myVal = myVal;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	public Node<E> getPrev() {
		return prev;
	}
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	public String toString() {
		return "" + myVal;
	}
	
}
