public class Journal extends Publication
{
    private String journalName;
    private double impactFactor;

    public Journal(String name, int numberOfAuthors, double impactFactor, String journalName)
    {
        super(name, numberOfAuthors);
        this.impactFactor = impactFactor;
        this.journalName = journalName;
    }

    public double computeScore()
    {
        return (impactFactor * 0.5) / super.getNumberOfAuthors();
    }
}
