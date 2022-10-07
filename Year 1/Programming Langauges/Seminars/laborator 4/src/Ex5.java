import java.util.Random;

public class Ex5
{
    public static void main(String args[])
    {
        Random randNr = new Random();

        int[][] m = new int[5][7];
        int max, Max;
        //umplem matricea cu numere aleatorii
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 7; j++)
                m[i][j] = randNr.nextInt( 100);
        //subpunctul a)
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 7; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
        //subpunctul b) si c)
        Max = m[0][0];
        for(int i = 0; i < 5; i++)
        {
            max = m[i][0];
            for (int j = 0; j < 7; j++)
            {
                if (Max < m[i][j])
                    Max = m[i][j];
                if (max < m[i][j])
                    max = m[i][j];
            }
                System.out.println("The biggest number on row " + (i + 1) + " is " + max + ".");
        }

        System.out.println("The biggest number in the entire matrix is " + Max + ".");
    }
}
