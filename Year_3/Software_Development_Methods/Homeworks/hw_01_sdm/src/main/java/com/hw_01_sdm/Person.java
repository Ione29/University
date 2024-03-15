package com.hw_01_sdm;

import java.time.LocalDate;
import java.util.Objects;
import java.util.ArrayList;

public class Person {
    private int id;
    private String name, job;
    private Address address;
    private LocalDate birthDate;
    private ArrayList<CreditCard> creditCards;

    public Person(){}

    public Person(int vId, String vName, String vJob, LocalDate vBirthDate, Address vAddress){
        this.id = vId;
        this.name = vName;
        this.job = vJob;
        this.birthDate = vBirthDate;    
        this.address = vAddress;
    }

    public Person(int vId, String vName, String vJob, LocalDate vBirthDate, ArrayList<CreditCard> vCreditCards){
        this.id = vId;
        this.name = vName;
        this.job = vJob;
        this.birthDate = vBirthDate;    
        this.creditCards = vCreditCards;
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
        return "Address{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", birthDate=" + this.birthDate.toString() + '\'' +
                ", job='" + this.job + '\'' +
                ", creditCards=" + this.creditCards +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Address getAddress() {
        return this.address;
    }

    public String getJob(){
        return this.job;
    }

    public ArrayList<CreditCard> getCreditCards(){
        return this.creditCards;
    }

    public void setId(int id) {
        this.id = id;
    }

}
