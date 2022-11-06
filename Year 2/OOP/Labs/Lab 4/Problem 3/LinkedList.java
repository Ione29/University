import java.util.NoSuchElementException;

public class LinkedList<T> implements Collection<T>{
    private Node<T> first;

    private static class Node<U>{
        Node<U> next;
        U value;

        public Node(U value) {
        this.value = value;
        }
    }

    private class ListIterator implements Iterator<T>{
        private Node<T> current;
        
        ListIterator(){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T val = current.value;
            current = current.next;
            return val;
        }
    }
    
    public void add(T val) {
        if (first == null)
            first = new Node<T>(val);
        else {
            Node<T> current = first;
            while (current.next != null)
                current = current.next;
            current.next = new Node<T>(val);
        }
    }

    public void add(T val , int index){
        if(first == null){
            first = new Node<T>(val);
        }
        else{
            Node<T> current = first;
            int verifIndex = 0;
            while(current.next != null){
                verifIndex++;
                current = current.next;
                if(verifIndex == index) {
                    Node<T> copieCurrent = current;
                    if(copieCurrent != null)
                        copieCurrent = current.next.next;
                    current.next = new Node<T>(val);
                    current.next.next = copieCurrent;
                }
            }
        }
    }

    public T remove(){
        if (first == null)
            throw new NoSuchElementException();
        else {
            T val = first.value;
            first = first.next;
            return val;
        }
  }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
}