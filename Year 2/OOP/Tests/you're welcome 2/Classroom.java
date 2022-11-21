import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Classroom{
    private ArrayList<Student> students;

    public Classroom(){
        students = new ArrayList<Student>();
    }

    public void addStudent(Student vStudent){
        students.add(vStudent);
    }
    
    public Map<Student, Integer> toMap(){
        
        Map<Student, Integer> studentMap = new HashMap<Student,Integer>();
    
        for(Student student : students)
            studentMap.put(student, (Integer)student.getCourseList().size());

        return studentMap;
    }   
}
