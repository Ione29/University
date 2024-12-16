import java.time.LocalDate;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Person p = new Person("John Doe", LocalDate.now(), "johndoe@email.com", "0745678165");
        PersonalData data = new PersonalData(p);
        Client c = new Client(data);
        System.out.println(c.getPersonalInformation());
    }
}
