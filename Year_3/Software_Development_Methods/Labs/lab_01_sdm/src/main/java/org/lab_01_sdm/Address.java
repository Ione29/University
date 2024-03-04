package org.lab_01_sdm;

import java.util.Objects;

public class Address {
    private int id;
    private String city,street;

    public Address(){}

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address(int id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setId(int id) {
        this.id = id;
    }
}
