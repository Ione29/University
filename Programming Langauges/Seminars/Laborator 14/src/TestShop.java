import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestShop
{
    public static void main(String[] args)
    {
        ArrayList<HardwareProduct> produsHardware = new ArrayList<>();
        try
        {
            //we read the data about the video cards
            File file1 = new File("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Seminars\\Laborator 14\\src\\PlaciVideo.txt");
            Scanner reader1 = new Scanner(file1);
            while(reader1.hasNextLine())
                produsHardware.add(new VideoCard(reader1.nextDouble(), reader1.nextDouble()));

            //we read the data about the monitors
            File file2 = new File("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Seminars\\Laborator 14\\src\\Monitoare.txt");
            Scanner reader2 = new Scanner(file2);
            while(reader2.hasNextLine())
                produsHardware.add(new Monitor(reader2.nextDouble(), reader2.nextDouble()));

            //we calculate the score of each product and show relevant information
            for(HardwareProduct i : produsHardware)
            {
                i.computePerformance();
                System.out.println(i);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("We were unable to read the text from the file.");
            e.printStackTrace();
        }
    }
}
