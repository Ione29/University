public class CreditAccount extends Account {
    private int maxCredit;

    public boolean withdraw(int ammount){
        if(this.ammount + maxCredit < ammount)
                return false;
        else{
            this.ammount -= ammount;
            return true;
        }
    }
}
