import java.util.Scanner;

public class Ex3
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        String sir, subsir;
        System.out.println("Type in the main string: ");
        sir = input.nextLine();
        System.out.println("Type in the substring: ");
        subsir = input.nextLine();

        int counter = 0, i = 0;
        while((i = sir.indexOf(subsir, i)) != -1)
        {
            counter++;
            i++;
        }
        System.out.println("The substring was found in the main string " + counter + " times.");
    }
}
