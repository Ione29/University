import java.util.Scanner;

public class Ex1
{
    public static boolean isPrime(int nr)
    {
        if(nr == 0 || nr == 1)
            return true;

        for(int d = 2; d <= nr / 2; d++)
            if(nr % d == 0)
                return false;

        return true;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        int nr;
        nr = input.nextInt();

        if(isPrime(nr))
            System.out.println("The given number is prime");
        else System.out.println("The given number is not prime");

    }
}
