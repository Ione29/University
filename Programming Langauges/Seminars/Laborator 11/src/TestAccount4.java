import java.util.Scanner;

public class TestAccount4
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        CurrentAccount cAccount1 = new CurrentAccount("Ionita Alexandru-Mihail",27, 4, 1);
        CurrentAccount cAccount2 = new CurrentAccount("Gigel", 69000, 10, 15);
        SavingsAccount sAccount1 = new SavingsAccount("Ionita Alexandru-Mihail", 25000, 0.75);
        SavingsAccount sAccount2 = new SavingsAccount("Gigel", 0.5);

        System.out.println();
        System.out.println("Initial information:\n");
        System.out.println(cAccount1.toString() + "\n");
        System.out.println(cAccount2.toString() + "\n");
        System.out.println(sAccount1.toString() + "\n");
        System.out.println(sAccount2.toString() + "\n");

        cAccount1.deposit(500);
        cAccount2.withdraw(420);
        sAccount1.withdraw(420);
        sAccount2.deposit(16000);
        System.out.println("--------------------------New information------------------------------\n");

        cAccount1.endOfMonth();
        cAccount2.endOfMonth();
        sAccount1.endOfMonth();
        sAccount2.endOfMonth();

        System.out.println(cAccount1.toString() + "\n");
        System.out.println(cAccount2.toString() + "\n");
        System.out.println(sAccount1.toString() + "\n");
        System.out.println(sAccount2.toString() + "\n");
    }
}
