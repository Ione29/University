public class Minibus extends Vehicle{

    public Minibus(double vBasePrice, String vName, String vCountry){
        this.basePrice = vBasePrice;
        this.country = vCountry;
        this.name = vName;
    }
    
    public double computeRoadTax(){
        return 0.03 * this.basePrice;
    }
}
