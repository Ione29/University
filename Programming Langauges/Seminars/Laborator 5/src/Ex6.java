import java.util.Scanner;

public class Ex6
{
    public static boolean palindrome(String s)
    {
        for(int i = 0; i < s.length() / 2; i++)
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }
    public static boolean recPalindrome(String s, int index)
    {
        if(index > s.length() / 2)
            return true;
        else
        if(s.charAt(index) == s.charAt(s.length() - 1 - index))
            return recPalindrome(s, index + 1);
        else
            return false;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s;
        System.out.println("Type in the string: ");
        s = input.nextLine();
        if(recPalindrome(s, 0))
            System.out.println("The given string is a palindrome.");
        else
            System.out.println("The given string is not a palindrome.");
    }
}