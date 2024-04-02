package com.hw_01_sdm.Address;

import java.util.Objects;

public class Address {
    private Integer id;
    private String street, city, country;

    public Address(){}

    public Address(String vCountry, String vCity, String vStreet){
        this.id = null;
        this.country = vCountry;
        this.city = vCity;
        this.street = vStreet;
    }

    public Address(int vId, String vCountry, String vCity, String vStreet){
        this.id = vId;
        this.country = vCountry;
        this.city = vCity;
        this.street = vStreet;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.id == address.id && Objects.equals(this.city, address.city) && Objects.equals(this.street, address.street) && Objects.equals(this.country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.city, this.street, this.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + this.id +
                " | city='" + this.city + '\'' +
                " | street='" + this.street + '\'' +
                " | country='" + this.country + '\'' +
                '}';
    }
}
