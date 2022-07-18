import java.util.Scanner;

public class Ex4
{
    public static int countChars(String s, char c)
    {
        int counter = 0, loc = 0;
        while((loc = s.indexOf(c, loc)) != -1)
        {
            counter++;
            loc++;
        }

        return counter;
    }

    public static int recCountChars(String s, char c)
    {
        if(s.length()==0) {
            return 0;
        }
        else
            if (s.charAt(0) == c) //daca gaseste
                return 1 + recCountChars(s.substring(1), c);

            else //daca nu gaseste
                return recCountChars(s.substring(1), c);
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        String sir;
        char c = 'r';
        System.out.println("Type in the main string: ");
        sir = input.nextLine();

        System.out.println("Character " + c + " appears in the string " + countChars(sir, c) + " times.");
        System.out.println("Character " + c + " appears in the string " + recCountChars(sir, c) + " times.");
    }
}
