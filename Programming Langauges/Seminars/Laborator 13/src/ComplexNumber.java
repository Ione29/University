public class ComplexNumber implements Number
{
    private int x=0,y=0;

    public void setComplexNumber(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return this.x + " + " + this.y + "i";
    }

    public ComplexNumber add(Number nr) {
        ComplexNumber z = new ComplexNumber();
        ComplexNumber z1 = (ComplexNumber) nr;
        z.x = this.x + z1.x;
        return z;
    }

    public ComplexNumber subtract(Number nr)
    {
        ComplexNumber z = new ComplexNumber();
        ComplexNumber z1 = (ComplexNumber) nr;
        z.x = this.x - z1.x;
        z.y = this.y - z1.y;
        return z;
    }

}