public class AccidentInsurance extends Insurance
{
    public AccidentInsurance(String firstName, String lastName, String address)
    {
        super(firstName, lastName, address);
    }

    public AccidentInsurance(String firstName, String lastName, String address, String frequency)
    {
        super(firstName, lastName, address, frequency);
    }

    public double computeAmountPerPeriod()
    {
        if(this.frequency.equals("half-yearly"))
            return super.amountPerPeriod * (1.05);
        else
            return super.amountPerPeriod;
    }
}
