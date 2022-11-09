import java.util.LinkedList;

public interface Map<K, V> {
    public void add(K key, V value);    
    public void remove(K key);
    public int size();
    public boolean isEmpty();
    public LinkedList<K> keys();
    public void print();
}
