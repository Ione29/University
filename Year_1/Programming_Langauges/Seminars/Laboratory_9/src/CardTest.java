public class CardTest
{
    public static void main(String[] args)
    {
        Card card1 = new Holiday("John");
        card1.greeting();

        Card card2 = new Birthday("Betty", 18);
        card2.greeting();
    }
}
