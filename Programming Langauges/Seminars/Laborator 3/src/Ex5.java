import java.util.Scanner;

public class Ex5
{
    public static void main(String[] args)
    {
        // 1 2 3 4 5 6 7 8 9
        // 1 2 3 4 5 6 7 8 9
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        int[][] mSum = new int[3][3];
        int[][] mProd = {{0,0,0},{0,0,0},{0,0,0}};

        Scanner input = new Scanner(System.in);
        //the first matrix
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                m1[i][j] = input.nextInt();
        //the second matrix
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                m2[i][j] = input.nextInt();
        //sum of the 2 matrices
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                mSum[i][j] = m1[i][j] + m2[i][j];

        System.out.println("The sum of the 2 matrices is:\n");
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                System.out.print(mSum[i][j] + " ");
            System.out.println();
        }

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                for(int k = 0; k < 3; k++)
                    mProd[i][j] += m1[i][k] * m2[k][j];

        System.out.println("The product of the 2 matrices is: \n");
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                System.out.print(mProd[i][j] + " ");
            System.out.println();
        }
    }
}

