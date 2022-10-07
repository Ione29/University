public class Holiday extends Card
{
    public Holiday(String recipient)
    {
        this.recipient = recipient;
    }

    public void greeting()
    {
        System.out.println("Dear " + recipient + ",");
        System.out.println("Season's Greetings!");
    }
}
