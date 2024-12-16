import java.time.LocalDate;

public class Person 
{
    private String name, email, telephone;
    private LocalDate birthDay;

    public Person(String name, LocalDate birthDay, String email, String telephone)
    {
        this.name = name;
        this. birthDay = birthDay;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName()
    {
        return this.name;
    }

    public LocalDate getBDay()
    {
        return this.birthDay;
    }  

    public String getEmail()
    {
        return this.email;
    }

    public String getTelephone()
    {
        return this.telephone;
    } 
}
