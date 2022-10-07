import java.util.Scanner;
public class Distance
{
    public static double distance(double x1, double y1, double x2, double y2)
    {
        double result;
        result = Math.sqrt( Math.pow( (x1 - x2) , 2) + Math.pow( (y1 - y2), 2));
        return result;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int x1, x2, y1, y2;
        x1 = input.nextInt();
        y1 = input.nextInt();
        x2 = input.nextInt();
        y2 = input.nextInt();

        System.out.println("The distance between the two given points is: " + distance(x1, x2, y1, y2));
    }
}