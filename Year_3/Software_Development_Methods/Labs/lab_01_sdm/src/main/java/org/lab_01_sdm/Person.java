package org.lab_01_sdm;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private Address address;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Address address){
        this.name = name;
        this.address = address;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, Address address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, address);
    }

    @Override
    public String toString(){
        return "Person{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", Address = " + address.toString() + "}";
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Address getAddress(){
        return this.address;
    }

    public void setId(int id){
        this.id = id;
    }
}
