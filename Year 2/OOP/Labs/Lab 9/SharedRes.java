import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedRes {
    private Queue<Sensor.SensorEvent> queue = new LinkedList<Sensor.SensorEvent>();
    private int limit;
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public SharedRes(int vLimit){
        this.limit = vLimit;
    }

    public void produce(Sensor.SensorEvent vEvent){
        lock.lock();
        while(queue.size() == limit){
            try{
                notFull.await();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(vEvent);
        notEmpty.signal();
        lock.unlock();
    }

    public Sensor.SensorEvent consume(){
        lock.lock();
        while(queue.isEmpty()){
            try {
                notEmpty.await();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        Sensor.SensorEvent event = queue.remove();
        notFull.signal();
        lock.unlock();
        return event;
    }
}