import java.security.KeyStore.Entry;

public class MapEntry<K,V> implements Entry {
    private K key;
    private V value;
    
    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
