package org.lab_01_sdm;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //initialize address DAO
        JDBCAddressDaoImpl addressDao=new JDBCAddressDaoImpl();
        Set<Address> addresses=addressDao.findAll();

        //initialize persons DAO
        JDBCPersonDaoImpl personsDao = new JDBCPersonDaoImpl();
        Set<Person> persons = personsDao.findAll();

        System.out.println("\nAddresses before adding:");
        addresses=addressDao.findAll();
        addresses.stream().forEach(System.out::println);
        
        System.out.println("\nPeople before adding:");
        persons=personsDao.findAll();
        persons.stream().forEach(System.out::println);
        
        System.out.println("--------------");

        //new person with new address
        System.out.println("Adding a new person with a new address:");
        Address alexAddress = new Address("Buzau", "Unirii");
        Person newPerson = new Person("Alex", alexAddress);
        personsDao.insert(newPerson);

        System.out.println("-----------------");

        System.out.println("Addresses after adding: ");
        addresses=addressDao.findAll();
        addresses.stream().forEach(System.out::println);
        
        System.out.println("\nPeople after adding:");
        persons=personsDao.findAll();
        persons.stream().forEach(System.out::println);

        personsDao.closeConnection();
        addressDao.closeConnection();
    }
}
