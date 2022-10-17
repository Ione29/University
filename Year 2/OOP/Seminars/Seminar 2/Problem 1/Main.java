import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client("ionel", LocalDate.ofYearDay(2002, 20), "1");
        Client c2 = new Client("razvan", LocalDate.ofYearDay(1999, 15), "2");
        
        DebitAccount a1 = new DebitAccount("1", 1000);
        CreditAccount a2 = new CreditAccount("2", 2000);
        c1.addAccount(a1);
        c2.addAccount(a2);

        System.out.println(a2.compareTo(a1));

        a1.store("output1.txt");
        a2.store("output2.txt");
    }
}
