import java.util.*;

public class AccountTest
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Type in the balance of the first account, then the balance of the second account: ");
        Account account1 = new Account("01","John", input.nextDouble());
        Account account2 = new Account("02","David", input.nextDouble());

        System.out.println("The balance of the first account is: " + account1.getBalance());
        System.out.println("The balance of the second account is: " + account2.getBalance());

        account1.processDeposit(2000);
        account2.processCheck(1500);

        System.out.println("The new balance of the first account is: " + account1.getBalance());
        System.out.println("The new balance of the second account is: " + account2.getBalance());
    }
}
