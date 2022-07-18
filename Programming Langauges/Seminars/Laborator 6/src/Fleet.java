public class Fleet
{
    private Car town;
    private Car suv;

    public Fleet(double Car1StartOdo, double Car1EndOdo, double Car1Liters,
                 double Car2StartOdo, double Car2EndOdo, double Car2Liters)
    {
        //create the 2 Car objects with the given data
        this.town = new Car(Car1StartOdo, Car1EndOdo, Car1Liters);
        this.suv  = new Car(Car2StartOdo, Car2EndOdo, Car2Liters);
    }

    public double averageConsumption()
    {
        return (this.town.computeConsumption() + this.suv.computeConsumption()) / 2;
    }
}
