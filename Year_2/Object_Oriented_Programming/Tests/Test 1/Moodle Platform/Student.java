import java.util.ArrayList;

public class Student implements Comparable{
    private String username;
    private String name;
    private String email;
    private ArrayList<Course> courses;

    public Student(String vUsername, String vName, String vEmail){
        this.username = vUsername;
        this.name = vName;
        this.email = vEmail;
        this.courses = new ArrayList<Course>();
    }

    public double getAverageGrade(){
        int passed = 0;
        double average = 0.0;
        for(Course course : courses)
            if(course.getGrade() != 0.0)
            {   
                passed++;
                average += course.getGrade();
            }

        average /= passed;

        return average;
    }

    public String getName(){
        return this.name;
    }

    public void addCourse(Course vCourse){
        if(courses.contains(vCourse))
            System.out.println("The student already takes this course");
        else
            courses.add(vCourse);
    }

    public ArrayList<Course> getCourseList(){
        return this.courses;
    }

    public int compareTo(Object vOther){
        Student other = (Student) vOther;
        if(this.name.compareTo(other.name) < 0)
            return -1;
        else if(this.name.compareTo(other.name) > 0)
            return 1;
        else 
            return 0;
    }
}
