public abstract class Vehicle implements Taxable, Comparable{
    protected double basePrice;
    protected String name, country;

    public Vehicle(double vBasePrice, String vName, String vCountry){
        this.basePrice = vBasePrice;
        this.country = vCountry;
        this.name = vName;
    }

    public Vehicle(){}

    public String toString(){
        String text = "Car Name: " + this.name + " | Base price: " + this.basePrice + " | Country of Origin: " + this.country;
        return text;
    }

    public abstract double computeRoadTax();

    public double computeVAT(){
        return 0.19 * this.basePrice;
    }

    public double computeCustomTax(){
        if(this.country.equals("Romania"))
            return 0;
        else return 0.10 * basePrice;
    }

    public double computeTotalTax(){
        return this.computeVAT() + this.computeCustomTax() + this.computeRoadTax();
    }

    //Problem 3 only
    public int compareTo(Object aThat) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this.computeTotalTax() == ((Vehicle)aThat).computeTotalTax()) 
            return EQUAL;
        if(this.computeTotalTax() < ((Vehicle)aThat).computeTotalTax())
            return BEFORE;
        else 
            return AFTER;    
    }
}