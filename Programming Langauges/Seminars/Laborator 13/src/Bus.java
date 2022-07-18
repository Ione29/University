public class Bus extends Vehicle
{
    public Bus(double basePrice, String name, String country)
    {
        this.basePrice = basePrice;
        this.name = name;
        this.country = country;
    }

    public double computeRoadTax()
    {
        return basePrice * 0.04;
    }

    public int compareTo(Vehicle o)
    {
        int result = (int) (o.computeTotalTax() - this.computeTotalTax());
        return result;
    }
}
