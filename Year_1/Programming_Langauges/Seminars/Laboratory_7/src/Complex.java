public class Complex
{
    private double re;
    private double im;

    public Complex()
    {
        this.re = 0.0;
        this.im = 0.0;
    }

    public Complex(double re, double im)
    {
        this.re = re;
        this.im = im;
    }

    public Complex add(Complex a, Complex b)
    {
        Complex c = new Complex();

        c.re = a.re + b.re;
        c.im = a.im + b.im;

        return c;
    }

    public Complex sub(Complex a, Complex b)
    {
        Complex c = new Complex();

        c.re = a.re - b.re;
        c.im = a.im - b.im;

        return c;
    }

    public Complex mult(Complex a, Complex b)
    {
        Complex c = new Complex();

        c.re = (a.re * b.re) + ((-1) * (a.im * b.im));
        c.im = (a.re * b.im) + (a.im * b.re);

        return c;
    }

    public Complex div(Complex a, Complex b)
    {
        Complex rez = new Complex();
        Complex num = new Complex();
        double den;

        num.re = (a.re * b.re) + (-1 * (a.im * (b.im * -1)));
        num.im = (a.re * (b.im * -1)) + (a.im * b.re);

        den = (b.re * b.re) + (b.im * b.im);

        rez.re = num.re / den;
        rez.im = num.im / den;

        return rez;
    }

    public void tupleFormat()
    {
        System.out.println("(" + re + "," + im + ")");
    }
}
