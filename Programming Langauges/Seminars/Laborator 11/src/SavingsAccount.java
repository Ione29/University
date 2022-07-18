import java.util.Calendar;

public class SavingsAccount extends BankAccount
{
    protected final double interestRate;

    public SavingsAccount(String owner, double interestRate)
    {
        super(owner);
        this.interestRate = interestRate;
    }

    public SavingsAccount(String owner, double balance, double interestRate)
    {
        super((long)balance, owner);
        this.interestRate = interestRate;
    }

    public double getInterest()
    {
        return this.interestRate;
    }

    public void applyInterest()
    {
        super.deposit(super.getBalance() * interestRate);
    }

    public String toString()
    {
        return super.toString() + "\nInterest Rate: " + this.interestRate;
    }


    public void endOfMonth()
    {
        Calendar cal = Calendar.getInstance();
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        if(cal.get(Calendar.DAY_OF_MONTH) == cal.getActualMaximum((Calendar.DATE)))
            getInterest();
    }
}
