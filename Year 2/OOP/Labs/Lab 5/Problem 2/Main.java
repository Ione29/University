import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

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
    
    Map<String, Employee> empMap = new HashMap<>();

    empMap.put(e1.getName(), e1);
    empMap.put(e2.getName(), e2);
    empMap.put(e3.getName(), e3);
    empMap.put(e4.getName(), e4);
    empMap.put(e5.getName(), e5);
    empMap.put(e6.getName(), e6);
    empMap.put(e7.getName(), e7);
    empMap.put(e8.getName(), e8);
    empMap.put(e9.getName(), e9);
    empMap.put(e10.getName(), e10);
    }   
}
