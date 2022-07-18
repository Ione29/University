public class CopyMachine extends OfficeAssistanceProduct
{
    private static int VAT = 20;

    public CopyMachine(int code, long costPrice)
    {
        super(code, costPrice);
    }

    public static void setVAT(int vat)
    {
        VAT = vat;
    }

    public long computeSellingPrice()
    {
        return (long)(super.costPrice +  VAT / 100.0 * super.costPrice);
    }
}