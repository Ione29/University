import java.util.Scanner;

public class Ex1
{
    public static void main(String[] args)
    {
        int n, a, b, c;
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Cate elemente se v-or afisa ?");
        n = tastatura.nextInt();
        a = 0; b = 1; n -= 2;
        System.out.print("0 1");
        while(n != 0)
        {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
            n--;
        }

    }
}

