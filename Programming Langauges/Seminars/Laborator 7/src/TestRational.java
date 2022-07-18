public class TestRational
{

    public static void main(String args[])
    {
        //data for testing
        Rational a = new Rational(2, 3);
        Rational b = new Rational(4, 5);
        Rational c = new Rational(14, 17);
        Rational d = new Rational(5, 9);
        Rational e = new Rational(2, 3);
        Rational f = new Rational(7, 10);
        Rational g = new Rational(4, 5);
        Rational h = new Rational(7, 10);

        //results of the operations
        Rational res1 = new Rational();
        Rational res2 = new Rational();
        Rational res3 = new Rational();
        Rational res4 = new Rational();

        res1 = res1.add(a, b);
        res2 = res2.sub(c, d);
        res3 = res3.mult(e, f);
        res4 = res4.div(g, h);

        System.out.println("Addition:");
        res1.intFormat();
        res1.realFormat();

        System.out.println();
        System.out.println("Substitution:");
        res2.intFormat();
        res2.realFormat();

        System.out.println();
        System.out.println("Multiplication:");
        res3.intFormat();
        res3.realFormat();

        System.out.println();
        System.out.println("Division:");
        res4.intFormat();
        res4.realFormat();

    }
}
