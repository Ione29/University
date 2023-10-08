import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Stack<String> strings = new Stack<String>();
        Stack<Person> persons = new Stack<Person>();

        strings.push("Adi");
        strings.push("Danut");
        strings.push("Victor");
        
        strings.print();
        strings.pop();
        System.out.println();
        strings.print();

        persons.push(new Person("Raluca", "12345", LocalDate.of(2002, 10, 4)));
        persons.push(new Person("Marian", "666", LocalDate.of(01, 01, 01)));
        persons.push(new Person("Enutza", "12435", LocalDate.of(6666, 11, 6)));
        
        persons.print();
        persons.pop();
        System.out.println();
        persons.print();
    }    
}
