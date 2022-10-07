public class Video
{
    private String title;
    private int length;
    private boolean available;

    public Video(String title)
    {
        this.title = title;
        this.length = 90;
        this.available = true;
    }

    public Video(String title, int length)
    {
        this.title = title;
        this.length = length;
        this.available = true;
    }

    public void show()
    {
        System.out.println("Title: \"" + this.title + "\"");
        System.out.println("Length: " + this.length + " minutes");
        System.out.println("Available ? : " + this.available);
    }
}

