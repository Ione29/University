public class Course {
    public enum Type{   
        FOUNDAMENTAL,
        SPECIALIZATION,
        DISCIPLINE
    }

    public enum Stream{
        ENGLISH,
        GERMAN,
        FRENCH
    }

    private final String name;
    private final Type type;
    private final Stream stream;
    private final int creditPoints;

    public String toString(){
        String text = "Course name: " + this.getName() + " | Stream: " + this.getStream() +  " | Type: " + this.getType() + " | No. of Credit Points: " + this.getCreditPoints();
        return text;
    }

    public Course(String vName, Type vType, Stream vStream, int vCreditPoints){
        if(vName == null)
            throw new RuntimeException("The name must be non-null.");
        else if(vType == null)
            throw new RuntimeException("The type must be non-null.");
        else if(vStream == null)
            throw new RuntimeException("The stream must be non-null.");
        else if(vCreditPoints < 0)
            throw new RuntimeException("The credit points must be non-negative.");

        this.name = vName;
        this.type = vType;
        this.stream = vStream;
        this.creditPoints = vCreditPoints;
    }

    public String getName(){
        return this.name;
    }

    public Type getType(){
        return this.type;
    }

    public Stream getStream(){
        return this.stream;
    }

    public int getCreditPoints(){
        return this.creditPoints;
    }

}