public class Course {
    private final String name;
    private Double grade;
    
    public Course(String vName){
        this.name = vName;
        this.grade = 0.0;
    }

    public Double getGrade(){
        return this.grade;
    }

    public String getName(){
        return this.name;
    }

    public void setGrade(Double vGrade){
        if(vGrade < 5)
            System.out.println("the course was not passed, and the grade will not be registered.");
        else
            this.grade = vGrade;
    }

    public boolean equals(Object vOther){
        Course other = (Course) vOther;
        return (name == null || name.equals(other.name));
    }
}
