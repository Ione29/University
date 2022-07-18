public class RealNumber implements Number, Comparable<RealNumber>
{
    private double x=0;

    public void setRealNumber(double d)
    {
        this.x = d;
    }

    public String toString()
    {
        return "" + this.x;
    }

    public RealNumber add(Number nr) {
        RealNumber z = new RealNumber();
        RealNumber z1 = (RealNumber) nr;
        z.x = this.x + z1.x;
        return z;
    }

    public RealNumber subtract(Number nr) {
        RealNumber z = new RealNumber();
        RealNumber z1 = (RealNumber) nr;
        z.x = this.x - z1.x;
        return z;
    }

    public int compareTo(RealNumber nr)
    {
        int result;
        if(nr.x > this.x)
            result = -1;
        else if(nr.x < this.x)
            result = 1;
        else result = 0;
        return result;
    }
}