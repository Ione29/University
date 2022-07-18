import java.util.Scanner;

public class Ex4
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //10 17 22 31 40 48 53 59 66 75
        int x, mid, low, high;
        boolean found = false;
        int[] sir = new int[11];

        for(int i = 0; i < 10; i++)
            sir[i] = input.nextInt();

        int n = input.nextInt();

        low = 0; high = sir.length - 1;
        mid = (low + high) / 2;

        while(low <= high)
        {
            if (sir[mid] == n)
            {
                System.out.println("Number " + n + " is found at position " + mid);
                found = true;
                break;
            }
            else if (sir[mid] < n)
                low = mid + 1;
            else high = mid - 1;

            mid = (low + high) / 2;
        }

        if(!found)
            System.out.println("The searched number could not be found");

    }
}

