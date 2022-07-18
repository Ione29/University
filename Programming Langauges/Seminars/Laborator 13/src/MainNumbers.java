import java.util.ArrayList;
import java.util.Collections;

public class MainNumbers
{
    public static void main(String[] args)
    {
        IntegerNumber a = new IntegerNumber();
        IntegerNumber a1 = new IntegerNumber();
        IntegerNumber r11 = new IntegerNumber();
        IntegerNumber r12 = new IntegerNumber();
        RealNumber b = new RealNumber();
        RealNumber b1 = new RealNumber();
        RealNumber r21 = new RealNumber();
        RealNumber r22 = new RealNumber();
        ComplexNumber c = new ComplexNumber();
        ComplexNumber c1 = new ComplexNumber();
        ComplexNumber r31 = new ComplexNumber();
        ComplexNumber r32 = new ComplexNumber();

        a.setIntegerNumber(5);
        a1.setIntegerNumber(6);
        b.setRealNumber(10.4);
        b1.setRealNumber(11.4);
        c.setComplexNumber(3, 4);
        c1.setComplexNumber(5, 6);

        r11 = a.add(a1);
        r12 = a.subtract(a1);
        r21 = b.add(b1);
        r22 = b.subtract(b1);
        r31 = c.add(c1);
        r32 = c.subtract(c1);

        System.out.println("a + a1 = " + a + " + " + a1 + " = " + r11);
        System.out.println("a - a1 = " + a + " - " + a1 + " = " + r12);
        System.out.println("b + b1 = " + b + " + " + b1 + " = " + r21);
        System.out.println("b - b1 = " + b + " - " + b1 + " = " + r22);
        System.out.println("c + c1 = (" + c + ") + (" + c1 + ") = " + r31);
        System.out.println("c - c1 = (" + c + ") - (" + c1 + ") = " + r32);

        ArrayList<IntegerNumber> intResults = new ArrayList<IntegerNumber>();
        ArrayList<RealNumber> realResults = new ArrayList<RealNumber>();

        intResults.add(r11);
        intResults.add(r12);

        System.out.println("Integer Results: ");
        for(IntegerNumber intNumber : intResults)
        {
            System.out.println(intNumber.toString());
        }

        Collections.sort(intResults);

        realResults.add(r21);
        realResults.add(r22);
        System.out.println("Real Results: ");
        for(RealNumber realNumber : realResults)
        {
            System.out.println(realNumber.toString());
        }
        Collections.sort(realResults);

        System.out.println("Integer Results Sorted: ");
        for(IntegerNumber intNumber : intResults)
        {
            System.out.println(intNumber.toString());
        }

        System.out.println("Real Results Sorted: ");
        for(RealNumber realNumber : realResults)
        {
            System.out.println(realNumber.toString());
        }

    }
}