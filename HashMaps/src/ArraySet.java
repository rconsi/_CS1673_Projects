import java.util.ArrayList;
import java.util.Iterator;

public class ArraySet<E> implements Set<E> {
	ArrayList<E> theSet;
	
	public ArraySet() {
		theSet = new ArrayList<E>();
	}
	@Override
	public Iterator<E> iterator() {
		//use built in arraylist iterator method
		return theSet.iterator();
	}

	@Override
	public boolean add(E e) {
		if(theSet.contains(e)) {
			return false;
		} else {
			theSet.add(e);
			return true;
		}
	}

	@Override
	public boolean remove(E e) {
		return theSet.remove(e);
	}

	@Override
	public void addAll(Set<E> T) {
		for(E e : T) {
			add(e);
		}
	}

	@Override
	public void retainAll(Set<E> T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll(Set<E> T) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(E e) {
		return theSet.contains(e);
	}

}
