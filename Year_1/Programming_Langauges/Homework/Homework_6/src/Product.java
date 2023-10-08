import java.util.Scanner;
public class Product
{
    static Scanner input = new Scanner(System.in);

    private String name;
    private double price;

    Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice()
    {
        this.price = input.nextDouble();
    }

    public double getPriceInRON()
    {
        return this.price / 10000;
    }

    public void setPriceInRON()
    {
        boolean modify = false;
        double modifier;

        System.out.println();
        System.out.println(this.name);
        System.out.println("Do you wish to add/subtract from the current price ? Y/N");
        String option;

        boolean ok;
        do
        {
            ok = true;
            option = input.nextLine();

            if("Y".equals(option) || "N".equals(option))
            {
                if ("Y".equals(option))
                    modify = true;
                else modify = false;
            }
            else
                ok = false;

        }while(!ok);

        if(modify)
        {
            System.out.println("What value do you wish to add to the price ?");
            modifier = input.nextDouble();
            this.price = this.getPriceInRON() + modifier;
        }
        else
        {
            System.out.println("Type in the new price in RON: ");
            this.price = input.nextDouble();
        }
        System.out.println("The new price is: " + this.price + ".");
    }

    public static void main(String args[])
    {
        Product product1 = new Product("Apples", 0);
        Product product2 = new Product("Pears", 0);
        System.out.println("Type in the price of the first product, in ROL: ");
        product1.setPrice();
        System.out.println("Type in the price of the second product, in ROL: ");
        product2.setPrice();

        System.out.println("Product 1: " + "\nName:" + product1.name + "\nPrice in ROL: " + product1.getPrice());
        System.out.println();
        System.out.println("Product 2: " + "\nName:" + product2.name + "\nPrice in ROL: " + product2.getPrice());

        System.out.println(product1.getPriceInRON());
        System.out.println(product2.getPriceInRON());

        product1.setPriceInRON();
        product2.setPriceInRON();

        System.out.println("Product 1: " + "\nName:" + product1.name + "\nPrice in RON: " + product1.getPriceInRON() * 10000);
        System.out.println();
        System.out.println("Product 2: " + "\nName:" + product2.name + "\nPrice in RON: " + product2.getPriceInRON() * 10000);
    }
}
