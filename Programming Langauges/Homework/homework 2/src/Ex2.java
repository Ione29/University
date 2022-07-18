import java.util.Locale;
import java.util.Scanner;
public class Ex2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String FirstName = input.nextLine();
        String LastName = input.nextLine();
        String CNP = input.nextLine();
        FirstName = FirstName.toLowerCase();
        LastName = LastName.toUpperCase();

        StringBuilder build = new StringBuilder();
        build.append(FirstName.charAt(0));
        build.append(FirstName.charAt(1));
        build.append(LastName.charAt(LastName.length() - 2));
        build.append(LastName.charAt(LastName.length() - 1));

        String password;
        password = build.toString();

        System.out.println(password);


    }
}