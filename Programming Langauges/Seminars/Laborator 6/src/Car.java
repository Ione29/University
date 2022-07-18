public class Car
{
    private double startKm;
    private double endKm;
    private double liters;

    public Car(double startKm, double endKm, double liters)
    {
        this.startKm = startKm;
        this.endKm = endKm;
        this.liters = liters;
    }

    public double computeConsumption()
    {
        return (this.liters / (this.endKm - this.startKm) ) * 100;
    }
}
