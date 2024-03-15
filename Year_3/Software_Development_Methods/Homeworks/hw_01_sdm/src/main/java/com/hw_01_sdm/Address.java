package com.hw_01_sdm;

import java.util.Objects;

public class Address {
    private int id;
    private String street, city, country;

    public Address(){}

    public Address(String vCity, String vStreet, String vCountry){
        this.street = vStreet;
        this.city = vCity;
        this.country = vCountry;
    }

    public Address(int vId, String vCity, String vStreet, String vCountry){
        this.id = vId;
        this.street = vStreet;
        this.city = vCity;
        this.country = vCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.id == address.id && Objects.equals(this.city, address.city) && Objects.equals(this.street, address.street) && Objects.equals(this.country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + this.id +
                ", city='" + this.city + '\'' +
                ", street='" + this.street + '\'' +
                ", country='" + this.country + '\'' +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCountry(){
        return this.country;
    }

    public void setId(int id) {
        this.id = id;
    }
}
