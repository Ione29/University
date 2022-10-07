import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class InOut
{

    public static void main(String[] args) throws IOException
    {
        FileInputStream fin = new FileInputStream("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Seminars\\Laborator 12\\src\\numbers.txt");
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader br = new BufferedReader(reader);
        String input = br.readLine();
        var numbers = input.split(" ");
        ArrayList<Integer> list = new ArrayList <Integer>();
        for(var number : numbers)
            list.add(Integer.parseInt(number));
        Collections.sort(list);
        File file = new File("output.txt");
        PrintWriter fout = new PrintWriter(new FileWriter("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Seminars\\Laborator 12\\src\\output.txt"));
        for(int i = 0; i < list.size(); i++)
        {
            int nr = (int)list.get(i);
            System.out.print(nr + " ");
            fout.print(nr + " ");
        }

        fout.close();
        br.close();
        reader.close();
        fin.close();;

    }
}