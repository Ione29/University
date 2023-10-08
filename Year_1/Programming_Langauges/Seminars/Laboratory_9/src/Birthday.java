public class Birthday extends Card
{
    private int age;
    public Birthday(String recipient, int age)
    {
        this.recipient = recipient;
        this.age = age;
    }

    public void greeting()
    {
        System.out.println("Dear " + this.recipient + ",");
        System.out.println("Happy " + this.age + "th Birthday!");
    }
}
