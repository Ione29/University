package gd_diana.ex_1;
import java.time.LocalDate;

public class User {
    
    public String username;
    public String email;
    public Status status;
    public String phone;
    
    protected String surname;
    protected String name;
    protected LocalDate birthday;

    private String password;
    private Settings settings;

    public User(String surname, String name, LocalDate birthday, String email, String phone){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }

    public User(String surname, String name, String birthday, String email, String phone){
        this.name = name;
        this.surname = surname;
        this.birthday = LocalDate.parse(birthday);
        this.email = email;
        this.phone = phone;
    }

    public void createAccount(String surname, String name, LocalDate birthday, String email, String phone){
        
    }

    @Override
    public String toString() {
        String text =   "\nUsername: " + this.username +
                        "\nFull Name : " + this.surname + " " + this.name +
                        "\nStatus: " + this.status +
                        "\nEmail: " + this.email +
                        "\nPhone: " + this.phone;
        return text;
    }
}
