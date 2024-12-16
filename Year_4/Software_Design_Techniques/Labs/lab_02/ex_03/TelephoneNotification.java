public class TelephoneNotification extends NotificationService{
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEvent.EventType.FIRE || event.getType() == SensorEvent.EventType.INTRUSION)
            System.out.println("A call was made for event " + event);
        if (next != null)
            next.handleEvent(event);
    }
}
