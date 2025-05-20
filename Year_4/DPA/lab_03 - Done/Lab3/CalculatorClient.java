import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator c = (Calculator) Naming.lookup(
                    "rmi://localhost/CalculatorService");

            // Test all operations
            System.out.println("Addition: " + c.add(4, 3));
            System.out.println("Subtraction: " + c.sub(4, 3));
            System.out.println("Multiplication: " + c.multiply(4, 3));
            System.out.println("Division: " + c.divide(4, 3));

            // Test division by zero
            try {
                System.out.println("Division by zero: " + c.divide(4, 0));
            } catch (RemoteException re) {
                System.out.println("Division by zero caught: " + re.getMessage());
            }
        }
        catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        }
        catch (java.lang.ArithmeticException ae) {
            System.out.println();
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        }
    }
}
