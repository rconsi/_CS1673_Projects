public interface Queue<E> {
    //Interface which implements Queue
	public void enqueue( E val);
	public E dequeue();
	public E getFirst();
	public int size();
	public boolean isEmpty();
}