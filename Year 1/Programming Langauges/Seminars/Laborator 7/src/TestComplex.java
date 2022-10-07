public class TestComplex
{
    public static void main(String args[])
    {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(4, 5);

        Complex res = new Complex();

        System.out.println("Addition:");
        res = res.add(a, b);
        res.tupleFormat();

        System.out.println();
        System.out.println("Substitution:");
        res = res.sub(a, b);
        res.tupleFormat();

        System.out.println();
        System.out.println("Multiplication:");
        res = res.mult(a, b);
        res.tupleFormat();

        System.out.println();
        System.out.println("Division:");
        res = res.div(a, b);
        res.tupleFormat();
    }
}
