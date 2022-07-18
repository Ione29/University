import java.util.*;

public class FleetTest
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Input data in this order:");
        System.out.println("First Car: start of the odometer, end of the odometer and liters consumed;");
        System.out.println("Second Car: start of the odometer, end of the odometer and liters consumed;");
        //create object of type Fleet and input the data
        Fleet flota = new Fleet(input.nextDouble(), input.nextDouble(), input.nextDouble(),
                                input.nextDouble(), input.nextDouble(), input.nextDouble());

        System.out.println("The average consumption of the fleet is " + flota.averageConsumption() + ".");
    }
}
