import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;
public class HashSet<E> implements Set<E> {
    private LinkedList<E>[] buckets;
    private int p;
    private int b;
    private int a;
    private int numEntries;
    private final int[] primes = {100663319,201326611,402653189,805306457,1610612741};

    public HashSet(){
        initMap(16);
    }

    @SuppressWarnings("unchecked")
    private void initMap(int bucketCount) {
        this.buckets = new LinkedList[ bucketCount ];
        this.numEntries = 0;

        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        this.p = primes[(int) Math.random() * primes.length];
        this.a = (int) (Math.random() * (p - 1) + 1);
        this.b = (int) (Math.random() * (p));
    }
    private int hashFunction(E e){
        int hashCode = e.hashCode();
        int idx = (((a * hashCode) + b) % p) % buckets.length;
        if (idx < 0){
            idx += buckets.length;
        }
        return idx;
    }
    private void expandIfNeeded(){
        if((double)numEntries / buckets.length > 0.75){
            LinkedList[] oldBuckets = buckets;
            initMap(buckets.length * 2);
            for(LinkedList<E> bucket : oldBuckets){
                for(E e : bucket){
                    add(e);
                }
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        ArrayList<E> theSet = new ArrayList<E>();
        for(LinkedList<E> bucket : buckets){
            for(E e : bucket){
                theSet.add(e);
            }
        }
        return theSet.iterator();
    }

    @Override
    public boolean add(E e) {
        int idx = hashFunction(e);
        if(buckets[idx].contains(e)){
            return false;
        } else{
            buckets[idx].add(e);
            numEntries++;
            expandIfNeeded();
            return true;
        }
    }

    @Override
    public boolean remove(E e) {
        int idx = hashFunction(e);
        if(!buckets[idx].contains(e)){
            return false;
        } else{
            buckets[idx].remove(e);
            numEntries--;
            expandIfNeeded();
            return true;
        }
    }

    @Override
    public boolean contains(E e) {
        int idx = hashFunction(e);
        return buckets[idx].contains(e);
       }

    @Override
    public void addAll(Set<E> T) {
        for(E e : T){
            add(e);
        }
    }

    @Override
    public void retainAll(Set<E> T) {
        Collection<E> coll = new ArrayList<E>();
        for(E e : this){
            if(T.contains(e)){
                coll.add(e);
            }
        }
        this.buckets = new LinkedList[16];
        initMap(16);
        for( E e : coll){
            add(e);
        }
    }
    @Override
    public void removeAll(Set<E> T) {
        for(E e : T){
            remove(e);
        }
    }
    public String toString(){
        String result = "";
        int maxBucket = 0;
        for(int i = 0; i < buckets.length; i++){
            result += "bucket " + i + " ( " + buckets[i].size() + ") -";
            if(buckets[i].size() > buckets[maxBucket].size()){
                maxBucket = i;
            }
            for(E bucket : buckets[i]){
                result += bucket + " ";
            }
        }
        return result;
    }
}
