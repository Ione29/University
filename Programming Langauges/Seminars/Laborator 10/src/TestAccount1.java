import java.util.Scanner;

public class TestAccount1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Account accounts[] = new Account[4];

        System.out.println();
        accounts[0] = new Account(27, "Ionita Alexandru-Mihail");
        accounts[1] = new Account("Gigel");
        accounts[2] = new SavingsAccount("Ionita Alexandru-Mihail", 25000, 0.75);
        accounts[3] = new SavingsAccount("Gigel", 0.5);

        for(int i = 0; i < 4; i++)
            System.out.println(accounts[i].toString() + "\n");

        for(int i = 0; i < 2; i++)
        {
            if (accounts[i] instanceof SavingsAccount)
            {
                SavingsAccount applyInterest = new SavingsAccount(" ", 0, 0);
                applyInterest = (SavingsAccount) accounts[i];
                applyInterest.applyInterest();
                accounts[i].deposit(applyInterest.getBalance());
            }
        }

        System.out.println("-------------------------------------------------------------------------------------\n");
        for(int i = 0; i < 4; i++)
            System.out.println(accounts[i].toString() + "\n");

        System.out.println("Please input the amount you wish to withdraw from account 1: ");
        accounts[0].withdraw(input.nextDouble());
        System.out.println(accounts[0].toString());

    }
}
