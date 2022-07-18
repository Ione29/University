import java.util.Scanner;
public class Ex4
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] v = new int[n];
        int seqLength = 0, maxLength = Integer.MIN_VALUE, seqStart = -1, prevStart = 0;
        boolean exists = false;

        for(int i = 0; i < n; i++)
            v[i] = input.nextInt();

        for(int i = 0; i < n; i++)
        {
            if(v[i] >= 0)
            {
                if(seqStart == -1)
                    seqStart = i;
                seqLength++;
                exists = true;
            }

            else
            {
                if (maxLength < seqLength)
                {
                    maxLength = seqLength;
                    prevStart = seqStart;
                }
                seqStart = -1;
                seqLength = 0;
            }
        }
        if(exists)
            System.out.println("The longest positive sequence starts from position " + prevStart + " and it has a lenght of " + maxLength + ".");
        else
            System.out.println("There is no positive sequence in the array.");

        // 1 2 -3 2 3 4 -6 8 2 3 5 1 -8 6
    }
}