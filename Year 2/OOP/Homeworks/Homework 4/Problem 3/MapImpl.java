import java.util.LinkedList;

public class MapImpl<K, V> implements Map<K, V>{
    
    public final LinkedList<K> keys = new LinkedList<K>();
    public LinkedList<V> values = new LinkedList<V>();

    public void add(K vKey, V vValue){
        keys.add(vKey);
        values.add(vValue);
    }

    public void remove(K vKey){
        int i = 0;

        for(K key : keys)
            if(!(key.equals(vKey)))
                i++;
            else 
                break;
        
        keys.remove(i);
        values.remove(i);
    }

    public int size(){
        return keys.size();
    }

    public boolean isEmpty(){
        return keys.isEmpty();
    }

    public LinkedList<K> keys(){
        return keys;
    }

    public void print(){
        for(int i = 0; i < keys.size(); i++)
            System.out.println("Key: " + keys.get(i) + " | Value: " + values.get(i));
        }
}
