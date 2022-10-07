public class Movie extends Video
{
    private String director;
    private double rating;

    public Movie()
    {
        super("Avatar");
        this.director = "Gigel";
        this.rating = 9.7;
    }

    public void show()
    {
        super.show();
        System.out.println("Director: " + this.director);
        System.out.println("Rating: " + this.rating);
    }
}
