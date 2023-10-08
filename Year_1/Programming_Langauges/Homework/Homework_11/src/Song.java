public class Song
{
    private String title;
    private String artist;
    private double duration;
    private String genre;

    public Song()
    {
        this.title = "";
        this.artist = "";
        this.duration = 0;
        this.genre = "";
    }

    public Song(String title, String artist, double duration, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getArtist()
    {
        return this.artist;
    }

    public double getDuration()
    {
        return this.duration;
    }

    public String toString()
    {
        return title + " " + artist + " " + duration + " " + genre;
    }
}