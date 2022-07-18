import java.io.*;
import java.util.*;

public class Company
{
    private String name, address, phoneNumber, email;

    public Company(String name, String address, String phoneNumber, String email)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public String getEmail()
    {
        return this.email;
    }
}
