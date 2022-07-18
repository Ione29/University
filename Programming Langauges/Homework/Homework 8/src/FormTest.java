public class FormTest
{
    public static void main(String[] args)
    {
        Form array[] = new Form[3];
        array[0] = new Point(1, 1);
        array[1] = new Circle(3, 1, 1);
        array[2] = new Cylinder(5, 3, 1, 1);
        for(int i = 0; i < array.length; i++)
        {
            System.out.println();
            if(array[i].computeArea() != 0)
                    System.out.println("The area is: " + array[i].computeArea());
            if(array[i].computeVolume() != 0)
                System.out.println("The volume is: " + array[i].computeVolume());
            System.out.println(array[i].toString());

        }

    }

}