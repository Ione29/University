package com.hw_01_sdm.Address;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import com.hw_01_sdm.CoreDaoJDBC;

public class AddressDAOJDBC extends CoreDaoJDBC implements AddressDAO{

    @Override
    public Set<Address> findAll() {
        Set<Address> addresses=new HashSet<>();
        String findAllAddressSQL = "SELECT * FROM address";
        try (
                PreparedStatement findAllAddress = connection.prepareStatement(findAllAddressSQL);
        ) {
            ResultSet rs = findAllAddress.executeQuery();
            while (rs.next()){
                Address ad=new Address(rs.getInt("id"), rs.getString("country"), rs.getString("city"),rs.getString("street"));
                addresses.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Set<Address> findByCountry(String country) {
        Set<Address> addresses = new HashSet<>();

        String findByCountrySQL = "SELECT * FROM address WHERE country = ?";
        try(
            PreparedStatement findByCountry = connection.prepareStatement(findByCountrySQL);
        ) {
            findByCountry.setString(1, country);
            ResultSet results = findByCountry.executeQuery();
            
            while(results.next()){
                Address foundAddress = new Address(results.getInt("id"), results.getString("country"), results.getString("city"), results.getString("street"));
                addresses.add(foundAddress);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return addresses;
    }

    @Override
    public Set<Address> findByCity(String city) {
        Set<Address> addresses = new HashSet<>();
        
        String findByCitySQL = "SELECT * FROM address WHERE city = ?";
        try(
            PreparedStatement findByCity = connection.prepareStatement(findByCitySQL);
        ) {
            findByCity.setString(1, city);
            ResultSet results = findByCity.executeQuery();
            
            while(results.next()){
                Address foundAddress = new Address(results.getInt("id"), results.getString("country"), results.getString("city"), results.getString("street"));
                addresses.add(foundAddress);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return addresses;
    }

    @Override
    public Set<Address> findByStreet(String street) {
        Set<Address> addresses = new HashSet<>();
        
        String findByStreetSQL = "SELECT * FROM address WHERE street = ?";
        try(
            PreparedStatement findByStreet = connection.prepareStatement(findByStreetSQL);
        ) {
            findByStreet.setString(1, street);
            ResultSet results = findByStreet.executeQuery();
            
            while(results.next()){
                Address foundAddress = new Address(results.getInt("id"), results.getString("country"), results.getString("city"), results.getString("street"));
                addresses.add(foundAddress);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return addresses;
    }

    @Override
    public Address insert(Address address) {
        String insertAddressSQL = "INSERT into address (country,city,street) values (?,?,?)";
        String checkAddressSQL = "SELECT * FROM address WHERE country = ?, city = ?, street = ?";

        try (
            PreparedStatement checkAddress = connection.prepareStatement(checkAddressSQL);
            PreparedStatement insertAddress = connection.prepareStatement(insertAddressSQL,Statement.RETURN_GENERATED_KEYS);
        ) {
            //check if the address already exists
            checkAddress.setString(1, address.getCountry());
            checkAddress.setString(2, address.getCity());
            checkAddress.setString(3, address.getStreet());
            ResultSet results = checkAddress.executeQuery();
            if(results.next())
                return address; //exit if the address is in the database

            insertAddress.setString(1,address.getCity());
            insertAddress.setString(2,address.getStreet());
            insertAddress.executeQuery();
            var generatedKeys = insertAddress.getGeneratedKeys();
            if (generatedKeys.next()) {
                address.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void update(Address address) {
        String updateAddressSQL = "UPDATE address SET country = ?, city = ?, street = ? WHERE id = ?";

        try(
            PreparedStatement updateAddress = connection.prepareStatement(updateAddressSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            updateAddress.setString(1, address.getCountry());
            updateAddress.setString(1, address.getCity());
            updateAddress.setString(2, address.getStreet());
            updateAddress.setInt(3, address.getId());
            updateAddress.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int addressId) {
        String deleteAddressSQL = "DELETE FROM address WHERE id = ?";
        try(
            PreparedStatement deleteAddress = connection.prepareStatement(deleteAddressSQL);
        ) {
            deleteAddress.setInt(1, addressId);
            deleteAddress.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
