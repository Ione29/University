public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        IntegerAscendingComparator comp = new IntegerAscendingComparator();
        String[] stringArr = {"cat", "phone", "car"};
        Integer[] intArr = {0, 4, 1, 2, 3, 5, 10};

        MyCollectons.sort(stringArr);

        for(String element : stringArr)
            System.out.print(element + " ");

        System.out.println();

        MyCollectons.sort(intArr, comp);
        for(Integer element : intArr)
            System.out.print(element + " ");
    }
}
