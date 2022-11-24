import java.time.LocalDate;
import java.util.ArrayList;

public class Crime {
    private String description;
    private String location;
    private LocalDate date;
    private String openPerson;
    private ArrayList<String> listOfSuspects;
    private ArrayList<Integer> characteristicsGrades;

    public Crime(String vDescription, String vLocation, String vOpenPerson, LocalDate vDate){
        this.description = vDescription;
        this.location = vLocation;
        this.date = vDate;
        this.openPerson = vOpenPerson;
        this.listOfSuspects = new ArrayList<String>();
        this.characteristicsGrades = new ArrayList<Integer>();
    }

    public ArrayList<String> getListOfSuspects(){
        return this.listOfSuspects;
    }

    public String getLocation(){
        return this.location;
    }

    public double getAverageGrade(){
        double averageGrade = 0;

        for(Integer attribute : characteristicsGrades)
            averageGrade += attribute;

        averageGrade /= characteristicsGrades.size();

        return averageGrade;
    }

    public void addAtribute(Integer vAttribute){
        this.characteristicsGrades.add(vAttribute);
    }

    public void addSuspect(String vSuspect){
        this.listOfSuspects.add(vSuspect);
    }

    public int compareTo(Object vOther){
        Crime other = (Crime) vOther;
        Integer int1 = this.listOfSuspects.size();
        Integer int2 = this.listOfSuspects.size();
        
        if(this.date.compareTo(other.date) > 0)
            return 1;
        else if(this.date.compareTo(other.date) < 0)
            return -1;
        else
            if(int1.compareTo(int2) > 0)
                return 1;
            else if(int1.compareTo(int2) < 0)
                return -1;
            else return 0;
    }

}
