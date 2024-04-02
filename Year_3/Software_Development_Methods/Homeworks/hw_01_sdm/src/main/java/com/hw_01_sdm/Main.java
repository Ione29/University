package com.hw_01_sdm;

import java.util.Set;
import java.sql.Date;
import java.util.ArrayList;

import com.hw_01_sdm.Address.*;
import com.hw_01_sdm.Person.*;
import com.hw_01_sdm.CreditCard.*;

public class Main {
    
    public static void printEverything(AddressDAOJDBC addressDAO, PersonDAOJDBC personDAO, CreditCardDAOJDBC creditCardDAO){
    
        Set<Address> addresses = addressDAO.findAll();
        Set<Person> persons = personDAO.findAll();
        Set<CreditCard> creditCards = creditCardDAO.findAll();
        
        System.out.println();
        System.out.println("Addresses: ");
        addresses.stream().forEach(System.out::println);
        
        System.out.println("\nPersons:");
        persons.stream().forEach(System.out::println);
        
        System.out.println("\nCredit Cards:");
        creditCards.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        AddressDAOJDBC addressDAO = new AddressDAOJDBC();
        PersonDAOJDBC personDAO = new PersonDAOJDBC();
        CreditCardDAOJDBC creditCardDAO = new CreditCardDAOJDBC();

        printEverything(addressDAO, personDAO, creditCardDAO);
        
        System.out.println("\n----------------------------------------------\n");
        
        
        Address newAddress = new Address("Bulgaria", "Sofia", "lalala");
        //addressDAO.insert(newAddress);
        
        CreditCard newCreditCard1 = new CreditCard("jkl", 1234);
        CreditCard newCreditCard2 = new CreditCard("m,.", 1234);
        Person newPerson = new Person("Diana", "Librarian", Date.valueOf("2002-02-28"), newAddress, new ArrayList<CreditCard>());
        
        newPerson.addCreditCard(newCreditCard1);
        newPerson.addCreditCard(newCreditCard2);
        
        System.out.println("Initialized in Java Main a new person with 2 credit cards.");

        personDAO.insert(newPerson);
        System.out.println("Added the person to the database!");

        System.out.println("\n----------------------------------------------");

        printEverything(addressDAO, personDAO, creditCardDAO);
    }
}