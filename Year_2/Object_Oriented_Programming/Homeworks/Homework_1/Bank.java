import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bank{
    public Loan loans[] = new Loan [100];
    private int nLoans;

    public Bank()
    {
        Loan loans[] = new Loan[100];
        this.nLoans = 0;
    }

    public String toString(Loan L){
        String text = "Loan ID:" + L.getId() + "; Person: " + L.getPerson().toString() + "; Ammount: " + L.getAmmount();
        return text;
    }

    public void addLoan(Loan L){
        loans[nLoans++] = L;
    }

    public boolean remove(Loan L){
        for(int i = 0; i < nLoans; i++)
            if(loans[i].equals(L))
            {
                for(int j = i; j < nLoans - 1; j++)
                    loans[j] = loans[j + 1];

                nLoans--;
                return true;
            }
        
        return false;
    }

    public Loan[] find(String name){
        Loan found[] = new Loan[100];
        int nFound = 0;

        for(int i = 0; i < this.nLoans; i++)
        if(this.loans[i].getPerson().getName().equals(name))
                found[nFound++] = loans[i];

        return found;
    }

    public Loan[] find(String name, double minAmmount){
        Loan found[] = new Loan[100];
        int nFound = 0;

        for(int i = 0; i < nLoans; i++)
            if(loans[i].getPerson().getName().equals(name) && loans[i].getAmmount() >= minAmmount)
                found[nFound++] = loans[i];

        return found;
    }

    public void printInFile(String fileName){
        try{
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);

            for(int i = 0; i < this.nLoans; i++)
                writer.write(this.loans[i].toString() + "\n");
        
            writer.close();    
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}