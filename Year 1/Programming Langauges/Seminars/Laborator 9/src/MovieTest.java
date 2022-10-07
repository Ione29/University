public class MovieTest
{
    public static void main(String[] args)
    {
        Video video = new Video("cats", 4);
        Video movie = new Movie();

        System.out.println("Video");
        video.show();
        System.out.println();
        System.out.println("Movie");
        movie.show();

    }
}
