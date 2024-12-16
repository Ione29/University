package ex_01;

public class MyArrayList implements MyList{

    private int[] array;
    private int size;

    public MyArrayList(){
        array =  new int[10];
        size = 0;
    }


    @Override
    public void add(int value) {
        array[size] = value;
        size++;
    }

    @Override
    public int get(int index) {
        if (index <0 || index >= size){
            throw new IndexOutOfBoundsException("Not a valid index");
        }

        return array[index];
    }
}