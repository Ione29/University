import java.util.Scanner;

public class Ex1
{
    public static boolean isPrime(int n)
    {
        if(n == 0 || n == 1)
            return true;

        for(int d = 2; d <= n / 2; d++)
            if(n % d == 0)
                return false;
        return true;
    }

    public static void genPrimes(int n)
    {
        for(int i = 0; i < n; i++)
            if(isPrime(i))
                System.out.print(i + " ");
    }

    public static boolean allPrimeDivisors(int n)
    {
        for(int d = 2; d <= n / 2; d++)
            if(n % d == 0)
                if (!isPrime(d))
                    return false;

        return true;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Type in a number: ");
        int nr;
        nr = input.nextInt();

        if(isPrime(nr))
            System.out.println(nr + " is prime.");
        else System.out.println(nr + " is not prime");

        System.out.println("All the prime numbers before " + nr + " are:");
        genPrimes(nr);
        System.out.println();
        if(allPrimeDivisors(nr))
            System.out.println("All the divisors of number " + nr + " are prime.");
        else
            System.out.println("All the divisors of number " + nr + " are not prime.");
    }
}
