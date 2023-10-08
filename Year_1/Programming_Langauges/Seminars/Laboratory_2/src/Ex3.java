public class Ex3
{
    public static void main(String[] args)
    {
        String prop = "i am a first year student now";
        System.out.println(prop);
        int[] v = {0, 0, 0, 0, 0};
        for(int ind = 0; ind < prop.length(); ind++)
        {
            char litera = prop.charAt(ind);
            switch(litera)
            {
                case 'a':
                    v[0]++;
                    break;
                case 'e':
                    v[1]++;
                    break;
                case 'i':
                    v[2]++;
                    break;
                case 'o':
                    v[3]++;
                    break;
                case 'u':
                    v[4]++;
                    break;
            }
        }

        System.out.println("a = " + v[0]);
        System.out.println("e = " + v[1]);
        System.out.println("i = " + v[2]);
        System.out.println("o = " + v[3]);
        System.out.println("u = " + v[4]);
    }
}
