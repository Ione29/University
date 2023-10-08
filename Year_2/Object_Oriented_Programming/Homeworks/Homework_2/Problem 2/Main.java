public class Main {
    public static void main(String[] args) {
        Minibus minibus = new Minibus(10000, "volswagen", "Germany");
        Bus bus = new Bus(25000, "Man", "Spain");
        Truck truck = new Truck(50000, "Dacia", "Romania");

        System.out.println(minibus.getClass());
        System.out.println(minibus.toString());
        System.out.println("VAT Tax:" + minibus.computeVAT());
        System.out.println("Road Tax:" + minibus.computeRoadTax());
        System.out.println("Customs Tax:" + minibus.computeCustomTax());
        System.out.println("Total Tax:" + minibus.computeTotalTax());

        System.out.println();

        System.out.println(bus.getClass());
        System.out.println(bus.toString());
        System.out.println("VAT Tax:" + bus.computeVAT());
        System.out.println("Road Tax:" + bus.computeRoadTax());
        System.out.println("Customs Tax:" + bus.computeCustomTax());
        System.out.println("Total Tax:" + bus.computeTotalTax());

        System.out.println();

        System.out.println(truck.getClass());
        System.out.println(truck.toString());
        System.out.println("VAT Tax:" + truck.computeVAT());
        System.out.println("Road Tax:" + truck.computeRoadTax());
        System.out.println("Customs Tax:" + truck.computeCustomTax());
        System.out.println("Total Tax:" + truck.computeTotalTax());


        ///Problem 3, no need to do another folder
        Vehicle vehicles[] = {truck, bus, minibus};

        ///ascending based on totalTaxes
        System.out.println("\nDescending sort based on total tax cost:");
        for (int i = 0; i < vehicles.length - 1; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < vehicles.length - i - 1; j++)
            {
                if(vehicles[j].computeTotalTax() < vehicles[j+1].computeTotalTax())
                {
                Vehicle temp;
                temp = vehicles[j];
                vehicles[j] = vehicles[j + 1];
                vehicles[j + 1] = temp;
                swapped = true;
                }
            }
        
            if (swapped == false)
                break;
        }

        for(int i = 0; i < vehicles.length; i++)
            System.out.println(vehicles[i].toString() + " | Total Taxes: " + vehicles[i].computeTotalTax()); 
        
        //descending based on basePrice
        System.out.println("\nDescending sort based on base price: ");
        for (int i = 0; i < vehicles.length - 1; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < vehicles.length - i - 1; j++)
            {
                if(vehicles[j].getBasePrice() > vehicles[j+1].getBasePrice())
                {
                Vehicle temp;
                temp = vehicles[j];
                vehicles[j] = vehicles[j + 1];
                vehicles[j + 1] = temp;
                swapped = true;
                }
            }
        
            if (swapped == false)
                break;
        }

        for(int i = 0; i < vehicles.length; i++)
            System.out.println(vehicles[i].toString()); 
        
    }
}
