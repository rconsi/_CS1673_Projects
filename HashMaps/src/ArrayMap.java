import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map.Entry;

public class ArrayMap<K,V> implements Map<K,V> {
	
	private ArrayList<Entry<K,V>> myList;
	public ArrayMap(){
		myList = new ArrayList<Entry<K,V>>();
	}
	@Override
	public int size() {
		return myList.size();
	}

	@Override
	public boolean isEmpty() {
		return myList.isEmpty();
	}
	
	@Override
	public V get(K key) {
		for(Entry<K,V> ent : myList) {
			if(ent.getKey().equals(key)) {
				return ent.getValue();
			}
		}
		return null;
	}

	@Override
	public V put(K key, V val) {
		for(Entry<K,V> ent : myList) {
			if(ent.getKey().equals(key)) {
				return ent.setValue(val);
			}
		}
		myList.add(new AbstractMap.SimpleEntry<K,V>(key,val));
		return val;
	}

	@Override
	public V remove(K key) {
		for(Entry<K,V> ent : myList) {
			if(ent.getKey().equals(key)) {
				myList.remove(ent);
				return ent.getValue();
			}
		}
		return null;
	}

	@Override
	public Iterable<K> keySet() {
		ArrayList<K> result = new ArrayList<K>();
		for (Entry<K,V> ent : myList) {
			result.add(ent.getKey());
		}
		return result;
	}

	@Override
	public Iterable<V> values() {
		ArrayList<V> res = new ArrayList<V>();
		for (Entry<K,V> ent : myList) {
			res.add(ent.getValue());
		}
		return res;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return myList;
	}
	
}

