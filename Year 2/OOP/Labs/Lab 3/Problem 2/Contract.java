import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class Contract implements Storable{
    ArrayList<Course> courses = new ArrayList<Course>();

    public Contract(Course c){
        courses.add(c);
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    public boolean removeCourse(String vName, Course.Type vType, Course.Stream vStream, int vCreditPoints){
        
        Course c = new Course(vName, vType, vStream, vCreditPoints);
        return courses.remove(c);
        
    }

    public void display(){
        for(Course c : courses){
            System.out.println(c.toString());
        }
    }

    public void sort()
    {
        Collections.sort(courses,
            new Comparator<Course>(){
                public int compare(Course c1, Course c2){
                    return c1.getName().compareTo(c2.getName());
                }
            });

        Collections.sort(courses,
            new Comparator<Course>(){
                public int compare(Course c1, Course c2){      
                    return c1.getType().compareTo(c2.getType());
                }
            });


        Collections.sort(courses,
        new Comparator<Course>(){
            public int compare(Course c1, Course c2){
                if(c1.getType() == c2.getType() && c1.getName() == c2.getName() && c1.getStream() == c2.getStream() && c1.getCreditPoints() == c2.getCreditPoints()){
                    throw new RuntimeException("There are two identical courses: " + c1.toString());
                }
                return c1.getStream().compareTo(c2.getStream());
            }
        });
    }
    
    public void store(String fileName){
        try{
            FileWriter writer = new FileWriter(fileName);
            
            for(Course c : courses)
                writer.write(c.toString() + "\n");

            writer.close();
        }catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
