public class VideoCard extends HardwareProduct
{
    private long currency;
    private final int maximumScore = 100;

    public VideoCard(double currencyPrice, double score)
    {
        super(currencyPrice, score);
        this.currency = (long)(currencyPrice * 4.90);
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
