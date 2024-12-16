import java.time.LocalDate;

public class SensorEvent {
    public enum EventType{
        FIRE, INTRUSION, WATER , TEMPERATURE
    }

    private EventType type;
    private LocalDate timestamp;
    private String location;

    public SensorEvent(EventType type, LocalDate timestamp, String location) {
        this.type = type;
        this.timestamp = timestamp;
        this.location = location;
    }

    public EventType getType() {
        return type;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", timestamp=" + timestamp +
                ", location='" + location + '\'' +
                '}';
    }

}
