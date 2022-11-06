public abstract class Account {
    protected String IBAN;
    protected int ammount;

    public String getIBAN(){
        return this.IBAN;
    }

    public int getAmmount(){
        return this.ammount;
    }

    public abstract boolean withdraw(int sum);
    public void deposit(int ammount)
    {

    }
}
