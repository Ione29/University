package ex_03;

public class LoggingDecorator implements MyList{

    private MyList wrappedList;

    public LoggingDecorator(MyList wrappedList){
        this.wrappedList = wrappedList;
    }


    @Override
    public void add(int value) {
        System.out.println("\n" + value +" was added to the list");
        wrappedList.add(value);
    }

    @Override
    public int get(int index) {
        return wrappedList.get(index);
    }

}