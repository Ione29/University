import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes.Name;

public class Main {
    
    public static void main(String[] args) {
    
    Employee e1 = new Employee("John Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Java", 1000.1);
    Employee e2 = new Employee("Jane Doe", "12343564124", LocalDate.of(2018, 1, 1), "C++", 1000.1);
    Employee e3 = new Employee("Ion Doe", "1234567890123", LocalDate.of(2018, 1, 1), "HR", 1000.1);
    Employee e4 = new Employee("Smith Doe", "1234567290123", LocalDate.of(2018, 1, 1), "Marketing", 1000.1);
    Employee e5 = new Employee("Theo Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Sales", 1000.1);
    Employee e6 = new Employee("Mircea Doe", "1294567890123", LocalDate.of(2018, 1, 1), "Management", 1000.1);
    Employee e7 = new Employee("Eduard Doe", "1234367890123", LocalDate.of(2018, 1, 1), "System Admin", 1000.1);
    Employee e8 = new Employee("Ovidiu Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Project Manager", 1000.1);
    Employee e9 = new Employee("Emanuel Doe", "12345983240123", LocalDate.of(2018, 1, 1), "Trainee", 1000.1);
    Employee e10 = new Employee("Sorin Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Trainee", 1000.1);
    
    Map<Name, Employee> empMap = new HashMap<>();

    //NOT FINISHED

    }   
}
