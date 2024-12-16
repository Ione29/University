package ex_03;

import java.util.LinkedList;

public class MyLinkedList implements MyList{

    private LinkedList<Integer> list;

    public MyLinkedList() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(int value) {
        list.add(value);
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }
}
