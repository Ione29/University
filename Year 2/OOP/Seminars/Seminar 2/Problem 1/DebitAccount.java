public class DebitAccount extends Account {
    public DebitAccount(String vIBAN, int vAmmount){
        this.IBAN = vIBAN;
        this.ammount = vAmmount;
    }
    
    public boolean withdraw(int ammount){
        if(this.ammount < ammount)
            return false;
        else{
            this.ammount -= ammount;
            return true;
        }
    }
    
}
