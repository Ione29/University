import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MinMaxAvg
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Seminars\\Laborator 12\\src\\numbers.txt");
        InputStreamReader reader = new InputStreamReader(file);
        BufferedReader br = new BufferedReader(reader);
        String input = br.readLine();
        String[] numbers = input.split(" ");
        double sum = 0;
        int nr = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length; i++)
        {
            int x = Integer.parseInt(numbers[i]);
            sum += x;
            if(x > max) max = x;
            else if (x < min) min = x;
            nr++;
        }

        sum /= nr;
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + sum);
    }
}
