import java.util.Scanner;
import java.util.StringTokenizer;
public class Ex2
{
    public static void main(String[] args)
    {
        //test: 9 8 7 6 5 4 3 2 1
        Scanner input = new Scanner(System.in);
        String sir = input.nextLine();
        sir.trim();
        String swap;

        StringTokenizer tokens = new StringTokenizer(sir, ", ");
        String[] temp = new String[tokens.countTokens()];
        int k = 0;
        while(tokens.hasMoreTokens())
            temp[k++] = tokens.nextToken();

        for(int i = 0; i < temp.length; i++)
            for(int j = i + 1; j < temp.length; j++)
                if(temp[i].compareTo(temp[j]) > 0)
                {
                    swap = temp[i];
                    temp[i] = temp[j];
                    temp[j] = swap;
                }

        for(int i = 0; i < temp.length; i++)
            System.out.print(temp[i]` + " ");
    }
}