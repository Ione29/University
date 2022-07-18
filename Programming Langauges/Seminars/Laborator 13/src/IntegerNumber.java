public class IntegerNumber implements Number, Comparable<IntegerNumber>
{

    private int x = 0;

    public void setIntegerNumber(int x)
    {
        this.x = x;
    }

    public String toString()
    {
        return "" + this.x;
    }

    public IntegerNumber add(Number nr) {
        IntegerNumber z = new IntegerNumber();
        IntegerNumber z1 = (IntegerNumber) nr;
        z.x = this.x + z1.x;
        return z;
    }

    public IntegerNumber subtract(Number nr) {
        IntegerNumber z = new IntegerNumber();
        IntegerNumber z1 = (IntegerNumber) nr;
        z.x = this.x - z1.x;
        return z;
    }

    public int compareTo(IntegerNumber nr)
    {
        int result = (int) (nr.x - this.x);
        return result;
    }

}