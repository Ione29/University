import java.util.Scanner;

public class Ex3
{
    public static void main(String[] args)
    {
        /*
        test
        8
        7
        1 6 3 0 8 4 1 7
         */
        Scanner input = new Scanner(System.in);
        int n, sum;

        n = input.nextInt();
        sum = input.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n - 1; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if (a[i] + a[j] + a[k] == sum)
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
    }
}