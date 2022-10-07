public class VideoTest
{
    public static void main(String[] args)
    {

     Video movie1 = new Video("Titanic");
     Video movie2 = new Video("Interstellar", 165);

     movie1.show();
     System.out.println();
     movie2.show();

    }
}
