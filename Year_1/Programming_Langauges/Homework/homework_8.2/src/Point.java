import java.util.*;
public class Point
{
    private int x,y;
    public Point()
    {
        x=0;
        y=0;
    }
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void setPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        return "x: " + x + " y: " + y;
    }
}