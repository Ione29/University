public class Account
{
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accNumber, String accHolder, double bal)
    {
        this.accountNumber = accNumber;
        this.accountHolder = accHolder;
        this.balance = bal;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void processDeposit(double amount)
    {
        this.balance = this.balance + amount;
    }

    public void processCheck(double amount)
    {
        if(this.balance < 10000)
            this.balance -= 15;
        this.balance -= amount;
    }
}
