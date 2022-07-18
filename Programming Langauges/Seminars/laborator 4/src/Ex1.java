public class Ex1
{
    public static void main(String[] args)
    {
        int[] a = {0, 1, 4, 7, 8, 10, 13, 14};
        int[] b = {2, 3, 5, 6, 9, 11, 12};
        int[] v = new int[16];
        int i = 0, j = 0, k = 0;

        while(i < a.length && j < b.length)
        {
            if(a[i] < b[j])
                v[k++] = a[i++];
            else
            if(a[i] > b[j])
                v[k++] = b[j++];
            else
            {
                v[k++] = a[i];
                i++;
                j++;
            }
        }

        while(i < a.length)
            v[k++] = a[i++];
        while(j < b.length)
            v[k++] = b[j++];
        //print the result
        for(i = 0; i < v.length - 1; i++)
            System.out.print(v[i] + " ");
    }

}