package org.lab_01_sdm;

import java.util.Optional;
import java.util.Set;

public interface PersonDAO {
    Set<Person> findAll();
    Set<Person> findByName(String name);
    Person insert(Person person);
    void update(Person person);
    void delete(int personId);
}
