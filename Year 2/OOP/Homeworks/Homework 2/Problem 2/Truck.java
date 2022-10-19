public class Truck extends Vehicle {

    public Truck(double vBasePrice, String vName, String vCountry){
        this.basePrice = vBasePrice;
        this.country = vCountry;
        this.name = vName;
    }

    public double computeRoadTax(){
        return 0.05 * this.basePrice;
    }
}
