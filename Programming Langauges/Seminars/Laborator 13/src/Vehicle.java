public abstract class Vehicle implements Taxable, Comparable<Vehicle>
{
    protected double basePrice;
    protected String name;
    protected String country;

    public String toString()
    {
        return "Base Price: " + this.basePrice + "\nName of the car: " + this.name + "\nCountry of origin: " + this.country + "\nTotal Tax: " + this.computeTotalTax();
    }

    public double computeVAT()
    {
        return basePrice * 0.19;
    }

    public abstract double computeRoadTax();

    public double computeCustomTax()
    {
        if(this.country.equals("Romania"))
            return 0;
        else return basePrice * 0.1;

    }

    public double computeTotalTax()
    {
        return computeCustomTax() + computeRoadTax() + computeVAT();
    }
}
