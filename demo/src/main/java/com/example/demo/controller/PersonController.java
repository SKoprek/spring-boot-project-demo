package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping(value = "/api")
public class PersonController {
    
    @Autowired
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(value = "/persons")
    public Iterable<Person> getPersons(){
        return personRepository.findAll();
    }
    @PutMapping(value = "/person")
    public Person addPerson(){
        return null;
    }
    @PatchMapping(value = "person")
    public Person editPerson(){
        return null;
    }
    @DeleteMapping(value = "person")
    public Person removePerson(){
        return null;
    }
}
