import java.util.*;

public class MatrixCalculations
{
    public static int sumMainDiagonal(int m[][])
    {
        int sum = 0;

        for(int i = 0; i < m.length; i++)
            sum += m[i][i];

        return sum;
    }

    public static int sumUnderMainDiagonal(int m[][])
    {
        int sum = 0;

        for(int i = 0; i < m.length; i++)
            for(int j = 0; j <= i; j++)
                sum += m[i][j];

        return sum;
    }

    public static int[][] matrixMultiplication(int a[][], int b[][])
    {
        int r, c;
        r = a.length;
        c = b[0].length;

        int prod[][] = new int[r][c];

        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
            {
                prod[i][j] = 0;

                for (int k = 0; k <= c; k++)
                    prod[i][j] += a[i][k] * b[k][j];
            }
        return prod;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        //create the matrix for the first 2 methods
        System.out.println("Introduce the number of rows/columns for the first matrix: ");
        int n = input.nextInt();
        int m[][] = new int[n][n];
        System.out.println("Introduce the " + (n * n) + " elements of the matrix: ");
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                m[i][j] = input.nextInt();
        //output of the first two methods
        System.out.println("The sum on the main diagonal is " + sumMainDiagonal(m));
        System.out.println("The sum under the main diagonal is " + sumUnderMainDiagonal(m));
        int am, an;

        //create and fill the first matrix
        System.out.println("Number of rows of the first matrix: ");
        am = input.nextInt();
        System.out.println("Number of columns of the first matrix: ");
        an = input.nextInt();
        int a[][] = new int[am][an];
        System.out.println("Enter the " + (am * an) + " elements of the first matrix: ");
        for(int i = 0; i < am; i++)
            for(int j = 0; j < an; j++)
                a[i][j] = input.nextInt();

        //create and fill the second matrix
        int bm, bn;
        System.out.println("Number of rows of the second matrix: ");
        bm = input.nextInt();
        System.out.println("Number of columns of the second matrix: ");
        bn = input.nextInt();
        int b[][] = new int[bm][bn];
        System.out.println("Enter the " + (bm * bn) + " elements of the second matrix: ");
        for(int i = 0; i < bm; i++)
            for(int j = 0; j < bn; j++)
                b[i][j] = input.nextInt();

        int c[][] = new int[am][bn];

        if(an == bm)//check if the matrices can be multiplied and act accordingly
        {
            c = matrixMultiplication(a, b);

            System.out.println("The result of the multiplication of the first 2 matrices is: ");
            for(int i = 0; i < am; i++)
            {
                for(int j = 0; j < bn; j++)
                    System.out.print(c[i][j] + " ");
                System.out.println();
            }
        }
        else
            System.out.println("The given matrices cannot be multiplied.");
        /*
        input test:
        2 3
        1 2 3
        4 5 6
        3 2
        1 2
        3 4
        5 6
        output should be
        22 28
        49 64
         */
    }
}
