public class Rational
{
    private int num = 0;
    private int den = 1;

    public static int cmmdc(int a, int b)
    {
        while(a != b)
            if(a > b)
                a -= b;
            else b -= a;
        return a;
    }

    public Rational()
    {
        this.num = 0;
        this.den = 1;
    }

    public Rational(int num, int den)
    {
        int div = cmmdc(num, den);

        this.num = num / div;
        this.den = den / div;
    }

    public Rational add(Rational a, Rational b)
    {
        Rational c = new Rational();

        c.num = a.num * b.den + b.num * a.den;
        c.den = a.den * b.den;

        int div = cmmdc(c.num, c.den);
        c.num /= div;
        c.den /= div;

        return c;
    }

    public Rational sub(Rational a, Rational b)
    {
        Rational c = new Rational();

        c.num = a.num * b.den - b.num * a.den;
        c.den = a.den * b.den;

        int div = cmmdc(c.num, c.den);
        c.num /= div;
        c.den /= div;

        return c;
    }

    public Rational mult(Rational a, Rational b)
    {
        Rational c = new Rational();

        c.num = a.num * b.num;
        c.den = a.den * b.den;

        int div = cmmdc(c.num, c.den);
        c.num /= div;
        c.den /= div;

        return c;
    }

    public Rational div(Rational a, Rational b)
    {
        Rational c = new Rational();

        c.num = a.num * b.den;
        c.den = a.den * b.num;

        int div = cmmdc(c.num, c.den);
        c.num /= div;
        c.den /= div;

        return c;
    }

    public void intFormat()
    {
        System.out.println(this.num + "/" + this.den);
    }

    public void realFormat()
    {
        System.out.println( (float)this.num / this.den);
    }
}
