public interface Set<E> extends Iterable<E> {
	
	boolean add(E e);
	
	boolean remove(E e);
	
	boolean contains(E e);
	
	void addAll(Set<E> T);
	
	void retainAll(Set<E> T);
	
	void removeAll(Set<E> T);
	
}