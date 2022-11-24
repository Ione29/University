import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        Student s1 = new Student("test1", "test1", "test1@hotmail.com");

        Course c1 = new Course("Linear Algebra");

        Classroom classroom = new Classroom();

        s1.addCourse(c1);

        classroom.addStudent(s1);
        

        Map<Student, Integer> studentMap = new HashMap<Student,Integer>();

        studentMap = classroom.toMap();
        


    }    
}
