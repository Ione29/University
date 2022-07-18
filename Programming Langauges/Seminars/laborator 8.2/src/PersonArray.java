public class PersonArray
{
    private Person[] person;
    private int noData;

    public PersonArray(int dimension)
    {
        this.person = new Person[dimension];
        this.noData = 0;
    }

    public void insert(String lastName, String firstName, int age)
    {
        this.person[noData++] = new Person(lastName, firstName, age);
    }

    public Person find(String searchName)
    {
        for(int i = 0; i < this.noData; i++)
            if(this.person[i].getLast().equals(searchName))
                return person[i];

        return null;
    }

    public boolean delete(String searchName)
    {
        for(int i = 0; i < this.noData; i++)
            if(this.person[i].getLast().equals(searchName))
            {
                for (i++; i < this.noData; i++)
                    this.person[i - 1] = this.person[i];

                this.noData--;
                return true;
            }
        return false;
    }

    public void displayArray()
    {
        for(int i = 0; i < this.noData; i++)
        {
            System.out.println();
            this.person[i].displayPerson();
        }
    }

}
