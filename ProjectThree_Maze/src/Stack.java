public interface Stack<E> {
    //Interface which implements Stack
    public void push(E val);
	public E pop();
	public E top(); //peaK()
	public int size();
	public boolean isEmpty();
}
