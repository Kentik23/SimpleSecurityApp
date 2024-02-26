package com.example.FirstSecurityApp.service;

import com.example.FirstSecurityApp.models.Person;
import com.example.FirstSecurityApp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
    }
}
