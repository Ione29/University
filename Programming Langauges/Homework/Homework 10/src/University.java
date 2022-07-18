public class University
{
    private String name;
    private String location;
    private Author[] authors = new Author[99];

    private int noOfAuthors = 0;

    public void addAuthor(Author a)
    {
        this.authors[this.noOfAuthors++] = a;
    }

    public double computeScore()
    {
        double score = 0;

        for(int i = 0; i < authors.length; i++)
            score += authors[i].computeScore();

        return score;
    }
}
