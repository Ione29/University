package com.hw_01_sdm.Person;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import com.hw_01_sdm.*;
import com.hw_01_sdm.Address.*;
import com.hw_01_sdm.CreditCard.*;

public class PersonDAOJDBC extends CoreDaoJDBC implements PersonDAO {
    
    @Override
    public Set<Person> findAll() {
        Set<Person> persons = new HashSet<>();
        Address foundAddress = new Address();
        String findAllPersonsSQL = "SELECT * FROM person";
        try(
            PreparedStatement findAllPersons = connection.prepareStatement(findAllPersonsSQL);
        ) {
            ResultSet personResults = findAllPersons.executeQuery();
            while(personResults.next()){  //for each person that we have found
            String findSpecificAddressSQL = "SELECT * from address where id = ?";
            String findCreditCardsSQL = "SELECT * FROM creditCard where owner_id = ?";
            try(
                PreparedStatement findSpecificAddress = connection.prepareStatement(findSpecificAddressSQL);
                PreparedStatement findCreditCards = connection.prepareStatement(findCreditCardsSQL);
            ) {
                findSpecificAddress.setInt(1, personResults.getInt("address"));
                ResultSet addressResults = findSpecificAddress.executeQuery();

                while(addressResults.next()){
                    foundAddress = new Address(addressResults.getInt("id"), addressResults.getString("country"), addressResults.getString("city"), addressResults.getString("street"));
                }
                
                findCreditCards.setInt(1, personResults.getInt("id"));
                ResultSet creditCardResults = findCreditCards.executeQuery();
                ArrayList<CreditCard> foundCreditCards = new ArrayList<>();
                
                while(creditCardResults.next()){
                    foundCreditCards.add(new CreditCard(creditCardResults.getInt("id"), creditCardResults.getString("IBAN"), creditCardResults.getDouble("amount"), creditCardResults.getInt("owner_id")));
                }

                Person per = new Person(personResults.getInt("id"), personResults.getString("name"), personResults.getString("job"), personResults.getDate("birthDate"), foundAddress, foundCreditCards);
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
        Address foundAddress = new Address();
        String findAllPersonsSQL = "SELECT * FROM person WHERE name = ?";
        try(
            PreparedStatement findAllPersons = connection.prepareStatement(findAllPersonsSQL);
        ) {
            findAllPersons.setString(1, name);
            ResultSet personResults = findAllPersons.executeQuery();
            while(personResults.next()){  //for each person that we have found
            String findSpecificAddressSQL = "SELECT * from address where id = ?";
            String findCreditCardsSQL = "SELECT * FROM creditCard where owner_id = ?";
            try(
                PreparedStatement findSpecificAddress = connection.prepareStatement(findSpecificAddressSQL);
                PreparedStatement findCreditCards = connection.prepareStatement(findCreditCardsSQL);
            ) {
                findSpecificAddress.setInt(1, personResults.getInt("address"));
                ResultSet addressResults = findSpecificAddress.executeQuery();

                while(addressResults.next()){
                    foundAddress = new Address(addressResults.getInt("id"), addressResults.getString("country"), addressResults.getString("city"), addressResults.getString("street"));
                }
                
                findCreditCards.setInt(1, personResults.getInt("id"));
                ResultSet creditCardResults = findCreditCards.executeQuery();
                ArrayList<CreditCard> foundCreditCards = new ArrayList<>();
                
                while(creditCardResults.next()){
                    foundCreditCards.add(new CreditCard(creditCardResults.getString("IBAN"), creditCardResults.getDouble("amount"), creditCardResults.getInt("owner_id")));
                }

                Person per = new Person(personResults.getInt("id"), personResults.getString("name"), personResults.getString("job"), personResults.getDate("birthDate"), foundAddress, foundCreditCards);
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
    public Person insert(Person person) {
        String checkAddressSQL = "SELECT * FROM address WHERE (country = ?) and (city = ?) and (street = ?)";
        String insertAddressSQL = "INSERT INTO address (country, city, street) values (?,?,?)";
        String insertCreditCardSQL = "INSERT INTO creditCard (IBAN, amount, owner_id) values (?,?,?)";
        String insertPersonSQL = "INSERT INTO person (name, address, birthDate, job) values (?,?,?,?)";
        
        Address address = person.getAddress();
        ArrayList<CreditCard> creditCards = person.getCreditCards();


        try (
            PreparedStatement checkAddress = connection.prepareStatement(checkAddressSQL, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertAddress = connection.prepareStatement(insertAddressSQL, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertPerson = connection.prepareStatement(insertPersonSQL, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertCreditCard = connection.prepareStatement(insertCreditCardSQL);       
        ) {
            checkAddress.setString(1, address.getCountry());
            checkAddress.setString(2, address.getCity());
            checkAddress.setString(3, address.getStreet());
            ResultSet results = checkAddress.executeQuery();
            int addressId;
            if(!results.next()){
                // insert the address if it doesn't exist yet in the table
                insertAddress.setString(1, address.getCountry());
                insertAddress.setString(2, address.getCity());
                insertAddress.setString(3, address.getStreet());
                insertAddress.executeUpdate();
            }
            
            var addressKeys = insertAddress.getGeneratedKeys();
            if (addressKeys.next()) {
                addressId = addressKeys.getInt(1);
                address.setId(addressId);

                insertPerson.setString(1, person.getName());
                insertPerson.setInt(2, addressId);
                insertPerson.setDate(3, person.getBirthday());
                insertPerson.setString(4, person.getJob());
                insertPerson.executeQuery();

                ResultSet personKeys = insertPerson.getGeneratedKeys();
                ResultSet personKeys1 = personKeys;
                if (personKeys1.next()) {
                    person.setId(personKeys.getInt(1));                
                }
                
                int personId = personKeys.getInt(1);
                person.setId(personId);

                for(CreditCard card : creditCards){
                    insertCreditCard.setString(1, card.getIBAN());
                    insertCreditCard.setDouble(2, card.getAmount());
                    insertCreditCard.setInt(3, personId);
                    insertCreditCard.executeQuery();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void update(Person person) {
        String updatePersonSQL = "UPDATE persons SET name = ?, address = ?, birthDate = ? AND job = ? WHERE id = ?";

        try(
            PreparedStatement updatePerson = connection.prepareStatement(updatePersonSQL);
        ) {
            updatePerson.setString(1, person.getName());
            updatePerson.setInt(2, person.getAddress().getId());
            updatePerson.setDate(3, person.getBirthday());
            updatePerson.setString(4, person.getJob());
            updatePerson.setInt(5, person.getId());
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