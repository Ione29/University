import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public Stack(){
        list = new LinkedList<T>();
    }

    public void push(T element){
        this.list.add(element);
    }

    public T pop(){
        if(this.list.isEmpty())
            throw new NoSuchElementException();
        else return this.list.removeLast();
    }

    public void print(){
        int i = 0;
        while(i <= this.list.size() - 1)
            System.out.println(this.list.get(i++));
    }

    
}
