import java.util.Scanner;

public class TestAccount2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Account account1 = new Account(27, "Ionita Alexandru-Mihail");
        Account account2 = new Account("Gigel");
        SavingsAccount sAccount1 = new SavingsAccount("Ionita Alexandru-Mihail", 25000, 0.75);
        SavingsAccount sAccount2 = new SavingsAccount("Gigel", 0.5);

        System.out.println();
        System.out.println(account1.toString() + "\n");
        System.out.println(account2.toString() + "\n");
        System.out.println(sAccount1.toString() + "\n");
        System.out.println(sAccount2.toString() + "\n");

        sAccount1.applyInterest();
        sAccount2.applyInterest();
        System.out.println("-------------------------------------------------------------------------------------\n");

        System.out.println(account1.toString() + "\n");
        System.out.println(account2.toString() + "\n");
        System.out.println(sAccount1.toString() + "\n");
        System.out.println(sAccount2.toString() + "\n");

        System.out.println("Please input the amount you wish to withdraw from account 1: ");
        account1.withdraw(input.nextDouble());
        System.out.println(account1.toString() + "\n");

    }
}
