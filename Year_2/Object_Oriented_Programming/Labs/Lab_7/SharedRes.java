import java.util.Queue;
import java.util.LinkedList;

public class SharedRes{
    private Queue<Candidate> queue = new LinkedList<>();
    private int limit;

    public SharedRes(int limit){
        this.limit = limit;
    }

    public synchronized void produce(Candidate vCandidate){
        while(queue.size() == limit){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        notify();
            queue.add(vCandidate);
    }

    public synchronized Candidate remove(){
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
