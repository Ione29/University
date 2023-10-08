public class Circle
{
    int radius;
    public Circle()
    {
        radius = 1;
    }
    public Circle(int r, int a, int b)
    {
        radius = r;
        setPoint(a, b);
    }
    public void setRadius(int r)
    {
        radius = r;
    }
    public String toString()
    {
        return "Radius: " + radius + " " +  Point.class.toString();
    }

    public double computeArea()
    {
        return Math.PI * (radius * radius);
    }

}