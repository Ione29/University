import java.util.Date;
import java.io.*;
import java.util.Scanner;

public class Beverage
{
    private String brand;
    private String ingredients;
    private int codebar;
    private float price;
    private int stock;
    private Company company;
    private Date productionDate;
    private Date expirationDate;

    public Beverage(String brand, String ingredients, int codebar, float price, int stock, Date productionDate, Date expirationDate)
    {
        this.brand = brand;
        this.ingredients = ingredients;
        this.codebar = codebar;
        this.price = price;
        this.stock = stock;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public String getBrand()
    {
        return this.brand;
    }

    public String[] getIngredients()
    {
        return this.ingredients;
    }

    public String getCodebar()
    {
        return this.codebar;
    }

    public float getPrice()
    {
        return this.price;
    }

    public Company getCompany()
    {
        return this.company;
    }

    public Date getProductionDate()
    {
        return this.productionDate;
    }

    public Date getExpirationDate()
    {
        return this.expirationDate;
    }

    public void setCompany(String name, String address, String phoneNumber, String email)
    {
        this.company = new Company(name, address, phoneNumber, email);
    }

}
