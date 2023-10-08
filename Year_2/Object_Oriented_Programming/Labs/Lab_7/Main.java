import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        SharedRes sharedRes = new SharedRes(10);        
        Candidate candidate;

        for(Integer i = 0; i < 100; i++){
            if(rand.nextInt(2) == 1)
                candidate = new Candidate("Mihai", 21, 10);
            else
                candidate = new Candidate("Costel", 14, 2);
            
            String threadName = i.toString();
            Producer producer = new Producer(threadName, sharedRes, candidate);
            Consumer consumer = new Consumer(threadName, sharedRes);
            producer.start();
            consumer.start();
        }
    }
}
