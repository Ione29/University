public class EmailNotification extends NotificationService{

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() != SensorEvent.EventType.TEMPERATURE)
            System.out.println("Email was sent for event " + event);
        if (next !=  null)
            next.handleEvent(event);
    }

}
