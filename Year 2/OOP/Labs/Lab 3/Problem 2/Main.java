public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("OOP", Course.Type.DISCIPLINE, Course.Stream.ENGLISH, 5);
        Course c2 = new Course("Physical Education", Course.Type.FOUNDAMENTAL, Course.Stream.GERMAN, 3);
        Course c3 = new Course("Spanish", Course.Type.SPECIALIZATION, Course.Stream.ENGLISH, 5);
        Course c4 = new Course("Math", Course.Type.FOUNDAMENTAL, Course.Stream.FRENCH, 4);
        Course dupe = new Course("Math", Course.Type.FOUNDAMENTAL, Course.Stream.FRENCH, 4);

        Contract contract = new Contract(c1);
        contract.addCourse(c2);
        contract.addCourse(c3);
        contract.addCourse(c4);

        //display test and store test
        System.out.println("\nDisplay test:");
        contract.display();
        contract.store("contract.txt");

        //sort test
        System.out.println("\nSort Test:");
        contract.sort();
        contract.display();
        
        //remove test
        System.out.println("\nRemove Test:");
        if(contract.removeCourse("OOP", Course.Type.DISCIPLINE, Course.Stream.ENGLISH, 5))
            System.out.println("Course removed.");
        else
            System.out.println("Course not found.");

        contract.display();
        
        //sort exception test should crash program
        System.out.println("\nSort Exception Test, should crash program:");
        contract.addCourse(dupe); // same as c4
        contract.sort();



    }
}
