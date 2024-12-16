import java.time.LocalDate;
import java.util.Random;

public class Sensor implements Runnable{
    private NotificationService notificationChain;
    public Sensor(NotificationService notificationChain) {
        this.notificationChain = notificationChain;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] rooms = {"Living Room", "Kitchen", "Bedroom", "Bathroom"};
        while (true){
            SensorEvent.EventType[] eventTypes = SensorEvent.EventType.values();
            SensorEvent.EventType randomEventType = eventTypes[random.nextInt(eventTypes.length)];
            String randomRoom = rooms[random.nextInt(rooms.length)];

            SensorEvent event = new SensorEvent(randomEventType, LocalDate.now(),randomRoom);
            notificationChain.handleEvent(event);
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
