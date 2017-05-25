package com.springCloud.person.controller;


import com.springCloud.person.dao.PersonRepository;
import com.springCloud.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String personName) {
        Person person = new Person(personName);
        personRepository.save(person);
        List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
        return people;
    }

}
