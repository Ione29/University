public class Logger extends NotificationService{
    @Override
    public void handleEvent(SensorEvent event) {
        System.out.println("Event " + event + " was logged." );
        if (next != null)
            next.handleEvent(event);
    }
}
