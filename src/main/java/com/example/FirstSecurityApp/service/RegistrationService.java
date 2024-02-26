package com.example.FirstSecurityApp.service;

import com.example.FirstSecurityApp.models.Person;
import com.example.FirstSecurityApp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final PersonRepository personRepository;

    @Autowired
    public RegistrationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void register(Person person) {
        personRepository.save(person);
    }
}
