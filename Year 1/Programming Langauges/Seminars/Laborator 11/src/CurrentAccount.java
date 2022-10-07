import java.util.Calendar;

public class CurrentAccount extends BankAccount
{
    private int transactionNo;
    private final int FREE_TRANSACTIONS;
    private final double TRANSACTION_COST;

    public CurrentAccount(String owner, double balance, int transNr, double transCost)
    {
        super(balance, owner);
        this.FREE_TRANSACTIONS = transNr;
        this.TRANSACTION_COST = transCost;
    }

    public void dischargeExpenses()
    {

    }

    public void endOfMonth()
    {
        Calendar cal = Calendar.getInstance();
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        if(cal.get(Calendar.DAY_OF_MONTH) == cal.getActualMaximum((Calendar.DATE)))
            dischargeExpenses();
    }
}
