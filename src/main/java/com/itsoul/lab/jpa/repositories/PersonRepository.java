package com.itsoul.lab.jpa.repositories;

import com.itsoul.lab.jpa.entites.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
    public Person findByName(String name);
}
