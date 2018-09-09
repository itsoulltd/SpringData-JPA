package com.itsoul.lab.jpa.controllers;

import com.itsoul.lab.jpa.entites.Person;
import com.itsoul.lab.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @RequestMapping("/findPersonByName")
    @ResponseBody
    public Person findByName(String name){
        List<Person> all = (List<Person>) personRepository.findAll();
        //Person result = personRepository.findByName(name);
        Optional<Person> result = all.stream().filter(person -> person.getName().equalsIgnoreCase(name)).findFirst();
        return result.get();
    }

}
