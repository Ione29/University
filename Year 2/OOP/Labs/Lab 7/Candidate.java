public class Candidate{
    private String name;
    private Integer age;
    private Integer educationLevel;

    public Candidate(String vName, Integer vAge, Integer vEducationLevel){
        this.name = vName;
        this.age = vAge;
        this.educationLevel = vEducationLevel;
    }

    public Integer getEducationLevel(){
        return this.educationLevel;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        String text = "Name: " + this.getName() + "\nAge: " + this.age + "\nEducation Level: " + this.educationLevel + "\n\n";
        return text;
    }
    
}
