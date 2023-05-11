import java.util.Map.Entry;

public interface Map<K,V> {
    public int size();
	public boolean isEmpty();
	public V get(K k);
	public V put(K k, V v);
	public V remove(K k);
	public Iterable<K> keySet();
	public Iterable<V> values();
	public Iterable<Entry<K,V>> entrySet();
}
