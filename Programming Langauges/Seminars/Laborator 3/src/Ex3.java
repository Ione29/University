import javax.swing.*;
import java.util.Scanner;
public class Ex3
{
    public static void main(String[] args)
    {
        //4 2 1 7 0 8 3 9 6 5
        int[] sir = new int[11];
        int min, max;
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 10; i++)
            sir[i] = input.nextInt();

        min = max = sir[0];

        for(int i = 1; i < 10; i++)
        {
            if(min > sir[i])
                min = sir[i];
            else if(max < sir[i])
                max = sir[i];
        }

        System.out.println("The minimum element is " + min + " and the maximum element is " + max);
    }
}

