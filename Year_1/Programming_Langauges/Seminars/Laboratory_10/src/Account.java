import java.lang.StringBuilder;
import java.util.Scanner;

public class Account
{
    private int id;
    private double balance;
    private String owner;
    private static int idCurrentAccount = 1;

    private static StringBuilder sb = new StringBuilder();
    private static Scanner input = new Scanner(System.in);

    public Account (long balance, String owner)
    {
        this.balance = balance;
        this.owner = owner;
        this.id = idCurrentAccount++;
    }

    public Account(String owner)
    {
        this.balance = 0;
        this.owner = owner;
        this.id = idCurrentAccount++;
    }

    public void deposit(double sum)
    {
        this.balance += sum;
    }

    public void withdraw(double sum)
    {
        boolean ok;
        do
        {
            ok = true;
            if(sum > this.balance)
            {
                System.out.println("You do not have enough money in your account in order to withdraw " + sum + " euro.");
                ok = false;
                System.out.println("Please input a new value to withdraw: ");
                sum = input.nextDouble();
            }
            else this.balance -= sum;
        }while(!ok);
    }

    public int getId()
    {
        return this.id;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public String getOwner()
    {
        return this.owner;
    }

    public String toString()
    {
        return "Account Details:\nOwner: " + getOwner() + "\nBalance: " + getBalance() + "\nAccount ID: " + getId();
    }
}