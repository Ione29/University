package org.lab_01_sdm;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class JDBCPersonDaoImpl extends CoreJDBCDao implements PersonDAO {
    
    @Override
    public Set<Person> findAll() {
        Set<Person> persons = new HashSet<>();
        Address foundAddress = new Address();
        String findAllPersonsSQL = "SELECT * FROM persons";
        try(
            PreparedStatement findAllPersons = connection.prepareStatement(findAllPersonsSQL);
        ) {
            ResultSet personResults = findAllPersons.executeQuery();
            while(personResults.next()){  //for each person that we have found
                String findSpecificAddressSQL = "SELECT * from addresses where id = ?";
                try(
                    PreparedStatement findSpecificAddress = connection.prepareStatement(findSpecificAddressSQL);
                ) {
                    findSpecificAddress.setInt(1, personResults.getInt("address"));
                    ResultSet addressResults = findSpecificAddress.executeQuery();
                    
                    while(addressResults.next()){
                        foundAddress = new Address(addressResults.getInt("id"), addressResults.getString("city"), addressResults.getString("street"));
                    }

                    Person per = new Person(personResults.getInt("id"), personResults.getString("name"), foundAddress);
                    persons.add(per);

                } catch (SQLException e) {
                    e.printStackTrace();   
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }   

    @Override
    public Set<Person> findByName(String name) {
        Set<Person> persons = new HashSet<>();
        String findByNameSQL = "SELECT * FROM persons WHERE name = ?";
        try(
            PreparedStatement findByName = connection.prepareStatement(findByNameSQL);
        ) {
            findByName.setString(1, name);
            ResultSet results = findByName.executeQuery();
            
            while(results.next()){
                Person per = new Person(results.getInt("id"), results.getString("name"));
                persons.add(per);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public Person insert(Person person) {
        String insertAddressSQL = "INSERT into addresses (street, city) values (?,?)";
        String insertPersonSQL = "INSERT into persons (name, address) values (?,?)";
        String checkAddressSQL = "SELECT * FROM addresses WHERE city = ? AND street = ?";
        Address address = person.getAddress();

        try (
            PreparedStatement checkAddress = connection.prepareStatement(checkAddressSQL);
            PreparedStatement insertAddress = connection.prepareStatement(insertAddressSQL, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertPerson = connection.prepareStatement(insertPersonSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            checkAddress.setString(1, address.getCity());
            checkAddress.setString(2, address.getStreet());
            ResultSet results = checkAddress.executeQuery();
            if(!results.next()){
                // insert the address if it doesn't exist yet in the address
                insertAddress.setString(1, address.getStreet());
                insertAddress.setString(2, address.getCity());
                insertAddress.executeUpdate();
            }

            var addressKeys = insertAddress.getGeneratedKeys();
            if (addressKeys.next()) {
                int addressId = addressKeys.getInt(1);
                address.setId(addressId);

                insertPerson.setString(1, person.getName());
                insertPerson.setInt(2, addressId);
                insertPerson.executeUpdate();

                var personKeys = insertPerson.getGeneratedKeys();
                if (personKeys.next()) {
                    person.setId(personKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void update(Person person) {
        String updatePersonSQL = "UPDATE persons SET name = ?, address = ? WHERE id = ?";

        try(
            PreparedStatement updatePerson = connection.prepareStatement(updatePersonSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            updatePerson.setString(1, person.getName());
            updatePerson.setInt(2, person.getAddress().getId());
            updatePerson.setInt(3, person.getId());
            updatePerson.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int personId) {
        String deletePersonSQL = "DELETE FROM persons WHERE id = ?";
        try(
            PreparedStatement deleteAddress = connection.prepareStatement(deletePersonSQL);
        ) {
            deleteAddress.setInt(1, personId);
            deleteAddress.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}