import java.util.Scanner;

public class CarTest
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        //create the object and input the data for the first car
        System.out.println("input the start and the end of the odometer and the number of liters of fuel consumed for the first car: ");
        Car masina1 = new Car(input.nextDouble(), input.nextDouble(), input.nextDouble());

        //create the object and input the data for the second car
        System.out.println("input the start and the end of the odometer and the number of liters of fuel consumed for the second car: ");
        Car masina2 = new Car(input.nextDouble(), input.nextDouble(), input.nextDouble());

        //calculate the consumption for both cars
        System.out.println("The first car consumes " + masina1.computeConsumption() + " liters of fuel per 100 kilometers.");
        System.out.println("The second car consumes " + masina2.computeConsumption() + " liters of fuel per 100 kilometers.");
    }
}
