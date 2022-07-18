import java.util.Scanner;

public class MatrixGenerators
{
    public static int[][] matrix1(int size)
    {
        int a[][] = new int[size][size];
        int k = 1;
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                a[i][j] = k++;

        return a;
    }

    public static int[][] matrix2(int size)
    {
        int a[][] = new int[size][size];
        int k = 1;

        for(int j = 0; j < size; j++)
            for(int i = 0; i < size; i++)
                a[i][j] = k++;

        return a;
    }

    public static int[][] matrix3(int size)
    {
        int a[][] = new int[size][size];
        int k = 1;
        for(int i = 0; i < size; i++)
            if(i % 2 == 0)
                for(int j = 0; j < size; j++)
                    a[i][j] = k++;
            else
                for(int j = 0; j < size; j++)
                    a[i][size - j - 1] = k++;

        return a;
    }

    public static int[][] matrix4(int size)
    {
        int a[][] = new int[size][size];
        int k = 1;

        int b = 0;
        int c = size - 1;
        int d = 0;
        int e = size - 1;
        while(b <= c && d <= e)
        {
            for (int x = b; x <= e; x++)
            {
                a[b][x] = k++;
            }
            for (int x = b + 1; x <= c; x++)
            {
                a[x][e] = k++;
            }
            if(b + 1 <= c)
            {
                for (int x = e-1; x >= d; x--)
                {
                    a[c][x] = k++;
                }
            }
            if(d + 1 <= e)
            {
                for (int x = c-1; x > b; x--)
                {
                    a[x][d] = k++;
                }
            }
            b++;
            c--;
            d++;
            e--;
        }

        return a;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int size;
        size = input.nextInt();
        int m1[][] = new int[size][size];
        int m2[][] = new int[size][size];
        int m3[][] = new int[size][size];
        int m4[][] = new int[size][size];

        System.out.println("Matrix 1");
        m1 = matrix1(size);

        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                System.out.print(m1[i][j] + " ");
            System.out.println();
        }

        System.out.println("Matrix 2");
        m2 = matrix2(size);
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                System.out.print(m2[i][j] + " ");
            System.out.println();
        }

        System.out.println("Matrix 3");
        m3 = matrix3(size);
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                System.out.print(m3[i][j] + " ");
            System.out.println();
        }

        System.out.println("Matrix 4");
        m4 = matrix4(size);
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                System.out.print(m4[i][j] + " ");
            System.out.println();
        }
    }
}
