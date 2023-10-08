import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

public class Workshop {
    private List<Mechanic> mechanics;
    private Queue<Car> carsToBeServiced;

    public Workshop(List<Mechanic> vMechanics){
        mechanics = vMechanics;
        for(Mechanic mechanic : mechanics)
            mechanic.start();
            
        carsToBeServiced = new LinkedList<Car>();
    }

    //refference method for GUI to add cars to the queue
    public void addInQueue(Car vCar){
        carsToBeServiced.add(vCar);
    }

    public synchronized Car remove(){
        while(carsToBeServiced.isEmpty()){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        notify();
            return carsToBeServiced.remove();
    }
}
