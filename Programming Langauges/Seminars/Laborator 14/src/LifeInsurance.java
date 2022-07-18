public class LifeInsurance extends Insurance
{
    public LifeInsurance(String firstName, String lastName, String address)
    {
        super(firstName, lastName, address);
    }

    public LifeInsurance(String firstName, String lastName, String address, String frequency)
    {
        super(firstName, lastName, address, frequency);
    }

    public double computeAmountPerPeriod()
    {
        if(this.frequency.equals("quarterly"))
            return super.amountPerPeriod * (1.02);
        else
            return super.amountPerPeriod;
    }
}
