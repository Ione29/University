public class Person {
    private String name;
    private String gender;
    private String jobDescription;
    private int yearsOfExperience;
    private String location;

    public Person(String vName, String vGender, String vJobDescription, int vYearsOfExperience, String vLocation){
        this.name = vName;
        this.gender = vGender;
        this.jobDescription = vJobDescription;
        this.yearsOfExperience = vYearsOfExperience;
        this.location = vLocation;
    }

    public String toString(){
        String text = "Name: " + this.name + " | Gender: " + this.gender + " | Job Description: " + this.jobDescription + " | Years of Experience: " + this.yearsOfExperience + " | Location: " + this.location; 
        return text;
    }
}
