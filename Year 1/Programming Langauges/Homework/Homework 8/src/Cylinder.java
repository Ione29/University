public class Cylinder extends Circle
{
    protected int height;

    public Cylinder()
    {
        this.height = 0;
        this.radius = 0;
        this.x = 0;
        this.y = 0;

    }

    public Cylinder(int h, int r, int a, int b)
    {
        this.height = h;
        this.radius = r;
        this.x = a;
        this.y = b;

    }

    public void setHeight(int h)
    {
        this.height= h;
    }

    public String toString(){
        String s = "This cylinder has the coordinates: (" + this.x + "," + this.y + "), the radius: " + this.radius + " and the height: " + this.height;
        return s;
    }

    public double computeArea()
    {
        return (2 * Math.PI * radius * (radius+height));
    }
    public double computeVolume()
    {
        return (Math.PI * Math.pow(radius, 2)*height);
    }
}