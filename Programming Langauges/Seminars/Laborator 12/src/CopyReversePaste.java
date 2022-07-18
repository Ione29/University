import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CopyReversePaste
{
    public static void main(String args[]) throws IOException {
        String nextSearch;
        File file = new File("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Seminars\\Laborator 12\\src\\test.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> sor = new ArrayList<String>();

        while(scan.hasNextLine()){
            nextSearch= scan.nextLine();
            sor.add(nextSearch);
        }

        Collections.reverse(sor);

        String fileName = "C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Seminars\\Laborator 12\\src\\out.txt";
        PrintWriter outputStream = new PrintWriter(fileName);
        for(String str : sor){
            outputStream.println(str);
        }
        outputStream.close();
    }
}