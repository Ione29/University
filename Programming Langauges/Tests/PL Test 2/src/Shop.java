import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop
{
    private Beverage[] beverages;

    public void reader() throws IOException
    {
        int i = 0;
        File data = new File("data.txt");
        Scanner reader = new Scanner(data);
        while(reader.nextLine().equals("--------"))
            beverages[i++].setCompany(reader.nextLine(), reader.nextLine(), reader.nextLine(), reader.nextLine());
        i = 0;
        while(reader.hasNextLine())
            beverages[i++] = new Beverage(reader.nextLine(), reader.nextLine(), Integer.parseInt(reader.nextLine()), Float.parseFloat(reader.nextLine()), Date.parse(reader.nextLine()), Date.parse(reader.nextLine()));



    }

    public void numberOfIngredients()
    {

    }
}
