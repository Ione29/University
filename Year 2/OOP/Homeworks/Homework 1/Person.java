public class Person {
    private String name;
    private String surname;
    private String cnp;

    public Person(String vName, String vSurname, String vCnp){
        this.name = vName;
        this.surname = vSurname;
        this.cnp = vCnp;        
    }

    public String getName()
    {
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getCnp(){
        return this.cnp;
    }

    public String toString(){
        String text = "Name: " + this.name + "; Surname: " + this.surname + "; CNP: " + this.cnp;
        return text;
    }
}
