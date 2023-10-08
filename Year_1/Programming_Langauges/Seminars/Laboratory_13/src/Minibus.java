public class Minibus extends Vehicle
{
    public Minibus(double basePrice, String name, String country)
    {
        this.basePrice = basePrice;
        this.name = name;
        this.country = country;
    }

    public double computeRoadTax()
    {
        return basePrice * 0.03;
    }

    public int compareTo(Vehicle o)
    {
        int result = (int) (o.computeTotalTax() - this.computeTotalTax());
        return result;
    }
}
