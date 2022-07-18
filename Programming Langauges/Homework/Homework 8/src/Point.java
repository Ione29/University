public class Point extends Form
{
    protected int x;
    protected int y;

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point(int a, int b)
    {
        this.x = a;
        this.y = b;
    }

    public void setPoint(int a, int b)
    {
        this.x = a;
        this.y = b;
    }

    public String toString()
    {
        String s = "This point has the coordinates: Point(" + this.x + "," + this.y + ")";
        return s;
    }

    public double computeArea()
    {
        return 0;
    }

    public double computeVolume()
    {
        return 0;
    }

}