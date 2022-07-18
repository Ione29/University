public abstract class OfficeAssistanceProduct
{
    protected int code;
    protected static int commisionPercent = 10;
    protected long costPrice;

    public OfficeAssistanceProduct(int code, long costPrice)
    {
        this.code = code;
        this.costPrice = costPrice;
    }

    public static void setCommision(int percent)
    {
        commisionPercent = percent;
    }

    public abstract long computeSellingPrice();

    public String toString()
    {
        return "The item with the code " + code + " has a commision percent of " + commisionPercent + "% and the VAT included price of " + computeSellingPrice();
    }

}