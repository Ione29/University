import java.io.FileWriter;
import java.io.IOException;

public abstract class Account implements Comparable, Storable {
    protected String IBAN;
    protected int ammount;

    public Account(String vIBAN, int vAmmount){
        this.IBAN = vIBAN;
        this.ammount = vAmmount;
    }

    public Account(){};

    public String getIBAN(){
        return this.IBAN;
    }

    public int getAmmount(){
        return this.ammount;
    }

    public abstract boolean withdraw(int sum);
    public void deposit(int ammount)
    {
        this.ammount += ammount;
    }

    
    public int compareTo(Object aThat) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this.equals(aThat)) 
            return EQUAL;
        if(this.IBAN.compareTo(((Account)aThat).getIBAN()) < 1)
            return BEFORE;
        else 
            return AFTER;    
    }

    public void store(String fileName){
        try{
            FileWriter writer = new FileWriter(fileName);
            writer.write(this.toString());
            writer.close();
        }catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public String toString(){
        String text = "IBAN: " + this.IBAN + " | Ammount: " + this.ammount + ";";

        return text;
    }
    
}
