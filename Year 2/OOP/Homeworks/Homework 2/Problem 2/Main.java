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
        Vehicle vehicles[] = {minibus, bus, truck };

        ///ascending based on totalTaxes
        


        //descending based on basePrice
    }
}
