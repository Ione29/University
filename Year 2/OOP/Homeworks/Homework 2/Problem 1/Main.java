public class Main {
    public static void main(String[] args) {
        Elipse elipse = new Elipse(0, 0, 5, 5);
        Rectangle rectangle = new Rectangle(0, 0, 4, 5);
        
        System.out.println(elipse.toString());
        elipse.enlarge(2.25);
        System.out.println(elipse.toString());
        
        System.out.println(rectangle.toString());
        rectangle.shrink(1.5);
        System.out.println(rectangle.toString());
    }
}