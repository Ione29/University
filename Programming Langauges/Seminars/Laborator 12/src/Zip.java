import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Zip {
    public static void main(String args[]) throws IOException {
        String nextSearch;
        File file = new File("E:\\proj\\zip.txt");
        Scanner scan = new Scanner(file);
        ArrayList<String> sor = new ArrayList<String>();
        int dim = 0;
        while (scan.hasNextLine()) {
            dim++;
            nextSearch = scan.nextLine();
            sor.add(nextSearch);
        }
        System.out.println("dimensiunea este: " + dim);
        Scanner keyboard = new Scanner(System.in);
        String searchTown = keyboard.nextLine();
        String searchState = keyboard.nextLine();
        int c=0;
        for(String element : sor){
            if(element.contains(searchTown) && element.contains(searchState)){
                System.out.println(element);
                c=1;
                break;
            }
        }
        if(c==0) System.out.println("not found");
    }
}