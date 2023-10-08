import java.util.Random;

public abstract class Insurance
{
    static Random rand = new Random();
    private int id;
    private int number = rand.nextInt(100000);
    private String firstName;
    private String lastName;
    private String address;
    private double sum;

    protected long amountPerPeriod;
    protected String frequency;

    public Insurance(String firstName, String lastName, String address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        frequency = "normal";
        this.amountPerPeriod = 13;
    }

    public Insurance(String firstName, String lastName, String address, String frequency)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.frequency = frequency;
        this.amountPerPeriod = 13;
    }

    abstract double computeAmountPerPeriod();

    public void computeSum()
    {
        this.sum = this.sum + this.computeAmountPerPeriod();
    }

    public String getFrequency()
    {
        return this.frequency;
    }

    public double getSum()
    {
        return this.sum;
    }

    public String toString()
    {
        return "Name: " + this.firstName + " " + this.lastName + "\nAddress: " + this.address + "\nImplicit amount to pay per period: " + amountPerPeriod + "\nFrequency: " + this.frequency;
    }
}
