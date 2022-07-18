import javax.swing.*;

public class Ex2
{
    public static void main(String[] args)
    {

        int a, b;
        a = Integer.parseInt(JOptionPane.showInputDialog("Type in the first number: "));
        b = Integer.parseInt(JOptionPane.showInputDialog("Type in the second number: "));

        while(a != b)
        {
            if(a >= b)
                a -= b;
            else b -= a;
        }

        System.out.println("The highest common divisor of the 2 numbers is : " + a);

    }
}

