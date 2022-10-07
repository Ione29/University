import java.util.*;
public class Ex1
{
    public static void noDuplicates(int[] a)
    {
        LinkedHashSet<Integer> newar = new LinkedHashSet<Integer>();
        for (int i = 0; i < a.length; i++)
            newar.add(a[i]);
        System.out.print(newar);
    }
    public static void main(String[] args)
    {
        int a[] = {5,2,6,8,6,7,5,2,8,5,1};
        noDuplicates(a);
    }
}