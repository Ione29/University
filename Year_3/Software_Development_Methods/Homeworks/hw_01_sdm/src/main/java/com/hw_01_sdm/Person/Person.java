package com.hw_01_sdm.Person;

import java.sql.Date;
import java.util.Objects;

import com.hw_01_sdm.Address.Address;
import com.hw_01_sdm.CreditCard.CreditCard;

import java.util.ArrayList;

public class Person {
    private Integer id;
    private String name, job;
    private Date birthDate;
    private Address address;
    private ArrayList<CreditCard> creditCards;

    public Person(){}

    public Person(String vName, String vJob, Date vBirthDate, Address vAddress, ArrayList<CreditCard> vCreditCards){
        this.id = null;
        this.name = vName;
        this.job = vJob;
        this.birthDate = vBirthDate;    
        this.address = vAddress;
        this.creditCards = vCreditCards;
    }

    public Person(int vId, String vName, String vJob, Date vBirthDate, Address vAddress, ArrayList<CreditCard> vCreditCards){
        this.id = vId;
        this.name = vName;
        this.job = vJob;
        this.birthDate = vBirthDate;    
        this.address = vAddress;
        this.creditCards = vCreditCards;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getJob(){
        return this.job;
    }

    public Date getBirthday(){
        return this.birthDate;
    }

    public Address getAddress() {
        return this.address;
    }

    public ArrayList<CreditCard> getCreditCards(){
        return this.creditCards;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addCreditCard(CreditCard creditCard){
        if(this.id != null) creditCard.setOwner_Id(this.id);
        this.creditCards.add(creditCard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.id == person.id && Objects.equals(this.name, person.name) && Objects.equals(this.job, person.job) && Objects.equals(this.birthDate, person.birthDate) && this.creditCards.equals(person.creditCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.job, this.birthDate, this.creditCards);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.id +
                " | name='" + this.name + '\'' +
                " | job='" + this.job + '\'' +
                " | birthDate=" + this.birthDate.toString() + '\'' +
                " | address: " + this.address.toString() + '\'' +
                " | creditCards=" + this.creditCards.toString() + '\'' +
                '}';
    }
}
