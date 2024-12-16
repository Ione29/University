package ex_03;

public class MySynchronizedList implements MyList{
    private int[] array;
    private int size;

    public MySynchronizedList(){
        array =  new int[10];
        size = 0;
    }

    @Override
    public synchronized void add(int value) {
        array[size] = value;
        size++;
    }
    
    @Override
    public synchronized int get(int index) {
        if (index <0 || index >= size){
            throw new IndexOutOfBoundsException("Not a valid index");
        }

        return array[index];
    }


}
