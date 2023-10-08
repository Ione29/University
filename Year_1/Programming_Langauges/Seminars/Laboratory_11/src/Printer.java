public class Printer extends OfficeAssistanceProduct
{
    private static int VAT = 15;

    public Printer(int code, long costPrice)
    {
        super(code, costPrice);
    }

    public long computeSellingPrice()
    {
        return (long)(super.costPrice + VAT / 100.0 * super.costPrice);
    }
}