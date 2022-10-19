public class Bus extends Vehicle{

    public Bus(double vBasePrice, String vName, String vCountry){
        this.basePrice = vBasePrice;
        this.country = vCountry;
        this.name = vName;
    }

    public double computeRoadTax(){
        return 0.04 * this.basePrice;
    }
}
