package com.db.springjpa.controller;

import com.db.springjpa.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return Arrays.asList(new Person(12134, "shashi", 26));
    }
}
