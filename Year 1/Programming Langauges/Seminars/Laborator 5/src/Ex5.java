import java.util.Scanner;

public class Ex5
{
    public static void modify(String s)
    {
        char[] string = s.toCharArray();
        char[] temp = new char[string.length];
        int j = 0;
        s = string.toString();
        for(int i = 0; i < string.length / 2; i++)
        {
            temp[j++] = string[i];
            temp[j++] = string[string.length - 1 - i];
        }

        s = String.valueOf(temp);
        System.out.println(s);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Type in the string: ");
        String s = input.nextLine();
        System.out.println("The new string is: ");
        modify(s);
    }
}