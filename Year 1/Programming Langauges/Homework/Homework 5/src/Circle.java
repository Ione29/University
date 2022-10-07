import java.util.*;

public class Circle
{
    private int x, y;
    private double radius;
    final double pi = Math.PI;

    Circle(int x, int y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea()
    {
        return pi * Math.pow(this.radius, 2);
    }

    public double getCircumference()
    {
        return 2 * pi * this.radius;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int a, b;
        double r, area, circumference;
        a = input.nextInt();
        b = input.nextInt();
        r = input.nextFloat();
        Circle circle = new Circle(a, b, r);
        area = circle.getArea();
        circumference = circle.getCircumference();

        System.out.println("The area of the given circle is: " + area);
        System.out.println("The circumference of the given circle is: " + circumference);
    }
}
