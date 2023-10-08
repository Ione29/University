package Threads;
import java.util.Queue;
import java.util.LinkedList;

public class Kitchen {
    private Queue<Pizza> queue = new LinkedList<Pizza>();
    private Integer limit;

    public Kitchen(Integer vLimit){
        this.limit = vLimit;
    }

    public synchronized void produce(Pizza vPizza){
        while(queue.size() == limit){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }   
        }

        notify();
            queue.add(vPizza);
    }

    public synchronized Pizza remove(){
        while(queue.isEmpty()){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        notify();
            return queue.remove();
    }
}
