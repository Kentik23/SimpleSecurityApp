package com.example.FirstSecurityApp.controllers;

import com.example.FirstSecurityApp.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();

        System.out.println(personDetails.getPerson().toString());

        return "hello";
    }
}
