import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Sensor extends Thread{
    public enum Type{
        BACK_DOOR,
        FRONT_DOOR,
        NURSERY,
        BEDROOM
    }
    private static AtomicInteger count = new AtomicInteger(1);
    private Integer sensorID;
    private Type sensorType;
    private SharedRes shared;

    public Sensor(String name, Type vEventType, SharedRes vShared){
        super(name);
        this.sensorType = vEventType;
        this.sensorID = count.getAndAdd(1);
        this.shared = vShared;
    }

    @Override
    public void run(){
        Random random = new Random();
        while(true){
            SensorEvent event = new SensorEvent();
            shared.produce(event);
            System.out.println("Event created by sensor " + event.sourceID + " was added.");
            try{
                sleep(random.nextInt(30));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public class SensorEvent{
        private final Integer sourceID;
        private final LocalTime eventTime;
        private final Type eventType;

        public SensorEvent(){
            this.sourceID = sensorID;
            this.eventTime = LocalTime.now();
            this.eventType = sensorType;
        }

        @Override
        public String toString(){
            String text = "Source: " + this.sourceID + " | Event Type: " + this.eventType + " | Time: " + this.eventTime;
            return text;
        }
    }
}