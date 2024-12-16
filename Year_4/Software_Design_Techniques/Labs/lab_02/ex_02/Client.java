public class Client implements PersonalInformation 
{
    private PersonalData data;

    public Client(PersonalData data)
    {
        this.data = data;
    }
    
    @Override
    public String getPersonalInformation()
    {
        return "{\n" +
                "\"name\": " + data.getName() + ", \n" +
                "\"bDay\": " + data.getBDay() + ", \n" +
                "\"email\": " + data.getEmail() + ", \n" +
                "\"telephone\": " + data.getTelephone() + ", \n"+
                "}";
    }
}
