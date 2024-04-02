package org.lab_01_sdm;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class JDBCAddressDaoImpl extends CoreJDBCDao implements AddressDAO{

    @Override
    public Set<Address> findAll() {
        Set<Address> addresses=new HashSet<>();
        String findAllAddressSQL = "SELECT * FROM addresses";
        try (
                PreparedStatement findAllAddress = connection.prepareStatement(findAllAddressSQL);
        ) {
            ResultSet rs = findAllAddress.executeQuery();
            while (rs.next()){
                Address ad=new Address(rs.getInt("id"),rs.getString("city"),rs.getString("street"));
                addresses.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Set<Address> findByCity(String city) {
        Set<Address> addresses = new HashSet<>();
        String findByCitySQL = "SELECT * FROM addresses WHERE city Address= ?";
        try(
            PreparedStatement findByCity = connection.prepareStatement(findByCitySQL);
        ) {
            findByCity.setString(1, city);
            ResultSet results = findByCity.executeQuery();
            
            while(results.next()){
                Address ad = new Address(results.getInt("id"), results.getString("city"), results.getString("street"));
                addresses.add(ad);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return addresses;
    }

    @Override
    public Address insert(Address address) {
        String insertAddressSQL = "INSERT into addresses(city,street) values(?,?)";
        String checkAddressSQL = "SELECT * FROM addresses WHERE city = ? AND street = ?";
        try (
            PreparedStatement checkAddress = connection.prepareStatement(checkAddressSQL);
            PreparedStatement insertAddress = connection.prepareStatement(insertAddressSQL,Statement.RETURN_GENERATED_KEYS);
        ) {
            //check if the address already exists
            checkAddress.setString(1, address.getCity());
            checkAddress.setString(2, address.getStreet());
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
        String updateAddressSQL = "UPDATE addresses SET city = ?, street = ? WHERE id = ?";

        try(
            PreparedStatement updateAddress = connection.prepareStatement(updateAddressSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
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
        String deleteAddressSQL = "DELETE FROM addresses WHERE id = ?";
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
