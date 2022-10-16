public class Main {
    public static void checkFound(Loan[] foundLoans){
        int i = 0, n = 0;
        
        while(foundLoans[i++] != null)
                n++;
                
        if(n== 0)
            System.out.println("No loans found");
        else 
        {
            System.out.println("Loans found:");

            for(int j = 0; j < n; j++)
                System.out.println(foundLoans[j].toString());
        }
    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        Person p1 = new Person("John", "Doe", "1");
        Person p2 = new Person("Jane", "Moe", "2");
        Person p3 = new Person("Mary", "Loe", "3");
        Person p4 = new Person("Roxy", "Joe", "4");
        Person p5 = new Person("Nick", "Poe", "5");
        
        //1
        Loan l1 = new Loan(1, 100, p1);
        //2
        Loan l2 = new Loan(2, 200, p2);
        Loan l3 = new Loan(3, 300, p2);
        //3
        Loan l4 = new Loan(4, 400, p3);
        Loan l5 = new Loan(5, 500, p3);
        Loan l6 = new Loan(6, 600, p3);
        //4
        Loan l7 = new Loan(7, 700, p4);
        Loan l8 = new Loan(8, 800, p4);
        Loan l9 = new Loan(9, 900, p4);
        
        bank.addLoan(l1);
        bank.addLoan(l2);
        bank.addLoan(l3);
        bank.addLoan(l4);
        bank.addLoan(l5);
        bank.addLoan(l6);
        bank.addLoan(l7);
        bank.addLoan(l8);
        bank.addLoan(l9);
 
        bank.printInFile("output1.txt");
    
        System.out.println("Loans for John Doe:");
        checkFound(bank.find(p1.getName()));
        System.out.println("\nLoans for Jane Moe:");
        checkFound(bank.find(p2.getName()));
        System.out.println("\nLoans for Mary Loe, Minimum 500:");
        checkFound(bank.find(p3.getName(), 500));
        System.out.println("\nLoans for Roxy Joe, minimum 900:");
        checkFound(bank.find(p4.getName(), 900));
        System.out.println("\nLoans for Roxy Joe, minimum 1000:");
        checkFound(bank.find(p4.getName(), 1000));
        System.out.println("\nLoans for Nick Poe:");
        checkFound(bank.find(p5.getName()));

        bank.remove(l1);
        bank.remove(l3);
        bank.remove(l7);
        bank.remove(l4);
        bank.remove(l2);

        bank.printInFile("output2.txt");

    }
}
