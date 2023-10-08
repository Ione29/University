public class CreditAccount extends Account {
    private int maxCredit;

    public CreditAccount(String vIBAN, int vAmmount){
        this.IBAN = vIBAN;
        this.ammount = vAmmount;
    }

    public boolean withdraw(int ammount){
        if(this.ammount + maxCredit < ammount)
                return false;
        else{
            this.ammount -= ammount;
            return true;
        }
    }
}
