package ex_03;

import ex_03.MyList.ListType;

public class Main {
    public static void main(String[] args) {

        // ArrayList
        MyList arrayList = new MyArrayList();
        MyList.getList(ListType.Array);
        arrayList.add(5);
        System.out.print(arrayList.get(0));
        
        // LinkedList
        MyList linkedList = new MyLinkedList();
        MyList.getList(ListType.LinkedList);
        linkedList.add(7);
        System.out.print(linkedList.get(0));
        
        // SynchronizedList
        MyList syncList = new MySynchronizedList();
        MyList.getList(ListType.SyncList);
        syncList.add(9);
        System.out.print(syncList.get(0));

        LoggingDecorator loggedList = new LoggingDecorator(MyList.getList(ListType.Array));
        loggedList.add(5);


    }
}
