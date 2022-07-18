public class Computer extends OfficeAssistanceProduct
{
    private static int VAT = 10;

    public Computer(int code, long costPrice)
    {
        super(code, costPrice);
    }

    public static void setVAT(int vat)
    {
        VAT = vat;
    }

    public long computeSellingPrice()
    {
        return (long)(super.costPrice + VAT / 100.0 * super.costPrice);
    }
}