import java.util.Scanner;

public class Ex2
{
    public static boolean isPerfect(int x)
    {
        int sum = 1;

        for(int d = 2; d <= x / 2; d++)
            if(x % d == 0)
                sum += d;

        if(sum == x)
            return true;
        else
            return false;
    }

    public static void main(String args[])
    {
        int nr;
        Scanner input = new Scanner(System.in);
        System.out.println("Type in a number: ");
        nr = input.nextInt();

        System.out.println("All the perfect numbers before " + nr + " are:");
        for(int i = 2; i < nr; i++)
            if(isPerfect(i))
                System.out.print(i + " ");

    }
}
