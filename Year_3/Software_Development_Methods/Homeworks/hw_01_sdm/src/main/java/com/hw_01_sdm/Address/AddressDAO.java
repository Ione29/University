package com.hw_01_sdm.Address;

import java.util.Set;

public interface AddressDAO {
    Set<Address> findAll();
    Set<Address> findByCountry(String name);
    Set<Address> findByCity(String city);
    Set<Address> findByStreet(String street);
    Address insert(Address address);
    void update(Address address);
    void delete(int AddressID);
}
