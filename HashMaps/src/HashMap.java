    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Map.Entry;

    public class HashMap<K,V> implements Map<K,V> {
        private final int[] primes = {100663319,201326611,402653189,805306457,1610612741};

        private LinkedList<Entry<K,V>>[] buckets;
        private int numEntries;

        private int p;
        private int b;
        private int a;
        
        public HashMap() {
            initMap(16);
        }
        private void initMap(int bucketCount) {
            this.buckets = new LinkedList [ bucketCount ];
            this.numEntries = 0;

            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
            this.p = primes[(int) Math.random() * primes.length];
            this.a = (int) (Math.random() * (p - 1) + 1);
            this.b = (int) (Math.random() * (p));
        }
        private int hashFunction(K key) {
            return (Math.abs(key.hashCode()) * a + b) % p % buckets.length;
        }
        @Override
        public int size() {
            throw new UnsupportedOperationException("Unimplemented method 'size'");
        }
        @Override
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
        }
        @Override
        public V get(K k) {
            int index = hashFunction(k);
            LinkedList<Entry<K,V>> bucket = buckets[index];
            for(Entry<K,V> entry : bucket){
                if(entry.getKey().equals(k)){
                    return entry.getValue();
                }
            }
            return null;
        }
        @Override
        public V put(K key, V val) {
        int index = hashFunction(key);
        LinkedList<Entry<K,V>> bucket = buckets[index];
        for(Entry<K,V> entry : bucket){
            if(entry.getKey().equals(key)){
                return entry.setValue(val);
            }
        }
        bucket.addFirst(new MapEntry(key,val));
        numEntries++;
        return null;
        }
        @Override
        public V remove(K k) {
            int index = hashFunction(k);
            LinkedList<Entry<K,V>> bucket = buckets[index];
            V value = null;
            for(Entry<K,V> entry : bucket){
                if(entry.getKey().equals(k)){
                    value = entry.getValue();
                    bucket.remove(entry);
                    numEntries--;
                }
            }
            return value;
        }
        
        @Override
        public Iterable<K> keySet() {
            ArrayList<K> result = new ArrayList<K>();
            for(int i = 0; i < buckets.length; i++){
                LinkedList<Entry<K,V>> bucket = buckets[i];
                for(Entry<K,V> entry : bucket){
                    result.add(entry.getKey());
                }
            }
            return result;
        }
        @Override
        public Iterable<V> values() {
            ArrayList<V> result = new ArrayList<V>();
            for(int i = 0; i < buckets.length; i++){
                LinkedList<Entry<K,V>> bucket = buckets[i];
                for(Entry<K,V> entry : bucket){
                    result.add(entry.getValue());
                }
            }
            return result;
        }
        @Override
        public Iterable<Entry<K, V>> entrySet() {
            ArrayList<Entry<K,V>> result = new ArrayList<Entry<K,V>>();
            for(int i = 0; i < buckets.length; i++){
                LinkedList<Entry<K,V>> bucket = buckets[i];
                for(Entry<K,V> entry : bucket){
                    result.add(entry);
                }
            }
            return result;
        }
        public String toString(){
            String result = "";
            int maxBucket = 0;
            for(int i = 0; i < buckets.length; i++){
                result += "bucket " + i + " ( " + buckets[i].size() + ") -";
                if(buckets[i].size() > buckets[maxBucket].size()){
                    maxBucket = i;
                }
                for(Entry<K,V> entry : buckets[i]){
                    result += entry + " ";
                }
            }
            System.out.println("Load Factor : " + loadFactor());
            return result;
        }
        public double loadFactor(){
            return (double) this.numEntries / buckets.length;
        }
        private void expandIfNeeded(){
            if(loadFactor() > 0.75){
            //Get all existing entries
            Iterable<Entry<K,V>> existingEntries = this.entrySet();
            //init the new larger map
            int newBucketCount = buckets.length * 2;
            this.initMap(newBucketCount);
            //Put all existing entries into the new larger map
            for(Entry<K,V> entry : existingEntries){
                this.put(entry.getKey(), entry.getValue());
            }
        }
    }
        public class MapEntry implements Entry<K,V> {
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
            @Override
            public String toString() {
                return "[ " + this.key + " = " + this.value + " ]";
            }
        }
}

