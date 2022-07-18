public class Author
{
    private String name;
    private Publication publications[] = new Publication[99];

    private int noOfPublications = 0;

    public void addPublication(Publication p)
    {
        if(p instanceof Journal)
            publications[noOfPublications++] = (Journal) p;
        else if(p instanceof ConferenceProceeding)
            publications[noOfPublications++] = (ConferenceProceeding) p;
    }

    public double computeScore()
    {
        double score = 0;

        for(int i = 0; i < 9; i++)
            score += publications[i].computeScore();

        return score;
    }
}
