public abstract class HardwareProduct
{
    protected double currentPrice;
    protected long leiPrice;
    protected double score;
    protected double performance;

    public HardwareProduct(double currentPrice, double score)
    {
        this.currentPrice = currentPrice;
        this.score = score;
    }

    public abstract void computePerformance();

    public double computeRatioLeiPricePerformance()
    {
        return this.leiPrice / this.performance;
    }

    public String toString()
    {
        return "Product: " + this.getClass().getSimpleName() + "\nPerformance: " + this.performance + "\nPrice in RON: " + this.leiPrice + "\nPrice to Performance Ratio: " + this.computeRatioLeiPricePerformance()  + "\n";
    }
}
