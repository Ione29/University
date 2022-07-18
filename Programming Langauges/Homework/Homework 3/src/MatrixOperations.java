import java.util.Scanner;
public class MatrixOperations
{
    public static double[][] matrixAdd(double m1[][], double m2[][])
    {
        double[][] mSum = new double[4][4];

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                mSum[i][j] = m1[i][j] + m2[i][j];

        return mSum;
    }

    public static double matrixDiagSum(double m1[][])
    {
        double DiagSum;
        DiagSum = 0;

        for(int i = 0; i < 3; i++)
            DiagSum += m1[i][i];

        return DiagSum;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        double[][] m1 = new double[3][3];
        double[][] m2 = new double[3][3];
        double[][] m3 = new double[3][3];

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                m1[i][j] = input.nextDouble();

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                m2[i][j] = input.nextDouble();

        m3 = matrixAdd(m1, m2);
        System.out.println("The sum of the 2 matrices is: ");
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                System.out.print(m3[i][j] + " ");
            System.out.println();
        }

        System.out.println("The sum of the elements on the first diagonal is: " + matrixDiagSum(m1));
        /*
        test
        1 2 3 4 5 6 7 8 9
        1 2 3 4 5 6 7 8 9
         */
    }
}