public class Monitor extends HardwareProduct
{
    private long currency;
    private final int maximumScore = 150;

    public Monitor(double currencyPrice, double score)
    {
        super(currencyPrice,score);
        this.currency = (long) (currencyPrice * 4.4);
        computePriceInLei();
    }

    public void computePriceInLei()
    {
        super.leiPrice = this.currency;
    }

    public void computePerformance()
    {
        super.performance = (super.score / maximumScore) * 100;
    }
}