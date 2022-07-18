import java.util.ArrayList;
import java.util.List;

public class TestShop
{
    public static void main(String[] args)
    {
        OfficeAssistanceProduct[] office = new OfficeAssistanceProduct[5];
        office[0] = new Printer(0, 20);
        office[1] = new CopyMachine(1, 10);
        office[2] = new Computer(2, 40);

        for(OfficeAssistanceProduct product : office)
        {
            if(product != null)
                System.out.println(product.computeSellingPrice());
        }

        for(OfficeAssistanceProduct product : office)
        {
            if(product != null)
                System.out.println(product);
        }

        List <OfficeAssistanceProduct> list = new ArrayList <OfficeAssistanceProduct>();
        list.add(new Printer(0, 20));
        list.add(new CopyMachine(1, 10));
        list.add(new Computer(2, 40));

        for(OfficeAssistanceProduct product : list)
            System.out.println(product.computeSellingPrice());

        for(OfficeAssistanceProduct product : list)
            System.out.println(product);
    }
}