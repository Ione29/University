public class Main 
{
    public static void main(String[] args) 
    {
        NotificationService emailNotification = new EmailNotification();
        NotificationService telephoneNotification = new TelephoneNotification();
        NotificationService logger = new Logger();

        emailNotification.setNext(telephoneNotification);
        telephoneNotification.setNext(logger);

        Sensor sensor = new Sensor(emailNotification);
        Thread sensorThread = new Thread(sensor);
        sensorThread.start();
    }
}
