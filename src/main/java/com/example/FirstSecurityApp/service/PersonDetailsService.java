package com.example.FirstSecurityApp.service;

import com.example.FirstSecurityApp.models.Person;
import com.example.FirstSecurityApp.repositories.PersonRepository;
import com.example.FirstSecurityApp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("Пользователь не найден!");

        return new PersonDetails(person.get());
    }
}
