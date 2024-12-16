public abstract class NotificationService {
    protected NotificationService next;
    public void setNext(NotificationService next){
        this.next = next;
    }

    public abstract void handleEvent(SensorEvent event);
}
