import java.util.*;
public class Cylinder{
    int height;
    public Cylinder()
    {
        height = 1;
    }
    public Cylinder(int h, int r, int a, int b)
    {
        height = h;
        setRadius(r);
        setPoint(a, b);
    }
    public void setHeight(int h)
    {
        height = h;
    }
    public String toString()
    {
        return "Height: " + height + " " + Circle.class.toString(); 
    }

    public double computeVolume()
    {
        return computeArea() * height;
    }
    
}