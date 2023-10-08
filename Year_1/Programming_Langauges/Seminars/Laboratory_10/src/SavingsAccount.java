public class SavingsAccount extends Account
{
    protected final double interest;

    public SavingsAccount(String owner, double interestRate)
    {
        super(owner);
        this.interest = interestRate;
    }

    public SavingsAccount(String owner, double balance, double interestRate)
    {
        super((long)balance, owner);
        this.interest = interestRate;
    }

    public double getInterest()
    {
        return this.interest;
    }

    public void applyInterest()
    {
        super.deposit(super.getBalance() * interest);
    }

    public String toString()
    {
        return super.toString() + "\nInterest Rate: " + this.interest;
    }
}
