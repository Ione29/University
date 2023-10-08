import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
        Employee dupe1 = new Employee("John Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Java", 1000.1);
        Employee dupe2 = new Employee("John Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Java", 1000.1);
        Employee dupe3 = new Employee("John Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Java", 1000.1);
        Employee dupe4 = new Employee("John Doe", "1234567890123", LocalDate.of(2018, 1, 1), "Java", 1000.1);

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);
        employees.add(e8);
        employees.add(e9);
        employees.add(e10);

        Iterator<Employee> iter = employees.iterator();

        System.out.println("Forward traversal:");
        while(iter.hasNext())
            System.out.println(iter.next());

        
        ListIterator<Employee> listIter = employees.listIterator();
        while(listIter.hasNext())
            listIter.next();

        System.out.println("Backwards traversal:");
        while(listIter.hasPrevious())
            System.out.println(listIter.previous());

        employees.add(dupe1);
        employees.add(dupe2);
        employees.add(dupe3);
        employees.add(dupe4);
        
        Set<Employee> empSet = new HashSet<Employee>(employees);

        Iterator<Employee> setIter = empSet.iterator();

        System.out.println("Set:");

        while(setIter.hasNext())
            System.out.println(setIter.next());

        TreeSet<Employee> treeSet = new TreeSet<Employee>(employees);

        System.out.println("Tree Set: ");
        for(Employee employee : treeSet)
            System.out.println(employee.toString());
        
    }
}