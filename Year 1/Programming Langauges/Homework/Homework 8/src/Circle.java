public class Circle extends Point
{
    protected int radius;

    public Circle()
    {
        this.x = 0;
        this.y = 0;
        this.radius = 0;

    }

    public Circle(int r, int a, int b)
    {
        this.radius = r;
        this.x = a;
        this.y = b;
    }
    public void setRadius(int r)
    {
        this.radius = r;
    }

    public String toString()
    {
        String s = "This circle has the coordinates: (" + this.x + "," + this.y + ") and the radius: " + this.radius;
        return s;
    }

    public double computeArea()
    {
        return (Math.PI * Math.pow(radius, 2));
    }

    public double computeVolume()
    {
        return 0;
    }

}