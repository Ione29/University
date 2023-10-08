import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Tests\\Exams\\bottles\\src\\sticle"));
        String line = input.readLine();
        String[] temp;

        Bottle[] sticle = new Bottle[999];
        int i = 0;

        //we read the bottles of wine
        while(line != null)
        {
            temp = line.split(" ");
            float capacity = Float.valueOf(temp[0]).floatValue();
            t

            if (price == 0)
            {
                price = capacity;
                sticle[i++] = new Bottle(price);
            }
            else
                sticle[i++] = new Bottle(capacity, price);

            line = input.readLine();
        }


        for(int j = 0; j < 5; j++)
            sticle[j].toString();


    }
}
