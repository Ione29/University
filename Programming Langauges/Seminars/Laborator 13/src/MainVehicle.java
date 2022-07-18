import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainVehicle
{
    public static void main(String[] args)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        vehicles.add(new Minibus(2500, "Opel Astra", "Sweden"));
        vehicles.add(new Truck(10000, "Dacia Logan", "Romania"));
        vehicles.add(new Bus(5000, "Volvo", "Germany"));

        Collections.sort(vehicles);
        int i = 1;
        for(Vehicle vehicle : vehicles)
        {
            System.out.println("Vehicle: " + (i++));
            System.out.println(vehicle);
            System.out.println();
        }

    }
}
