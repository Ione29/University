public class Person
{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String lastName, String firstName, int age)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void displayPerson()
    {
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Age: " + this.age);
    }

    public String getLast()
    {
        return this.lastName;
    }
}
