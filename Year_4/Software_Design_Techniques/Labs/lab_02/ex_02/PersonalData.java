import java.time.LocalDate;

public class PersonalData implements PersonalDataInterface
{
    private Person p;

    public PersonalData(Person p)
    {
        this.p = p;
    }

    @Override
    public String getName()
    {
        return p.getName();
    }

    @Override
    public LocalDate getBDay()
    {
        return p.getBDay();
    }  

    @Override
    public String getEmail()
    {
        return p.getEmail();
    }

    @Override
    public String getTelephone()
    {
        return p.getTelephone();
    }
}
