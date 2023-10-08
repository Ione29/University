public class ConferenceProceeding extends Publication
{
    private String volumeName;
    private boolean indexed;

    public ConferenceProceeding(String name, int numberOfAuthors, boolean indexed, String volumeName)
    {
        super(name, numberOfAuthors);
        this.indexed = indexed;
        this.volumeName = volumeName;
    }

    public double computeScore()
    {
        if(this.indexed)
            return 0.25 / super.getNumberOfAuthors();
        else
            return 0.2 / super.getNumberOfAuthors();
    }

}
