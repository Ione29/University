public class Portfolio
{
    Share[] shares = new Share[6];
    int noShares = 0;

    public void addShare(Share s)
    {
        shares[this.noShares] = s;
        this.noShares++;
    }

    public double computeSum()
    {
        double sum = 0;

        for(int i = 0; i < shares.length; i++)
            sum += shares[i].value;

        return sum;
    }
}
