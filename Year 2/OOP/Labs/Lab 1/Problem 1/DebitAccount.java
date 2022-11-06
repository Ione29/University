public class DebitAccount extends Account {
    public boolean withdraw(int ammount){
        if(this.ammount < ammount)
            return false;
        else{
            this.ammount -= ammount;
            return true;
        }
    }
    
}
