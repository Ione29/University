import java.util.*;

class TheDescend
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        // game loop
        while (true)
        {
            int max = 0;
            int pMax = 0;
            int i;
            for (i = 0; i < 8; i++)
            {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                if(max <= mountainH)
                {
                    max = mountainH;
                    pMax = i;
                }
            }
            //System.err.println(pMax);
            System.out.println(pMax);
        }
    }
}