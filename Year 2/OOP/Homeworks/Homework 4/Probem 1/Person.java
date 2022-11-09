import java.time.LocalDate;

public class Person {
    private String name;
    private String CNP;
    private LocalDate birthday;

    public Person(String vName, String vCNP, LocalDate vBirthday){
        this.name = vName;
        this.CNP = vCNP;
        this.birthday = vBirthday;
    }

    @Override
    public String toString(){
        String text = "Name: " + this.name + " | CNP: " + this.CNP + " | Birthday: " + this.birthday;
        return text;
    }

}
