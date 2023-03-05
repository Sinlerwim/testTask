package com.savin.testTask.service;

import com.savin.testTask.repository.PersonRepository;
import com.savin.testTask.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(String id) {
        return personRepository.findById(id).get();
    }

    public int getAgeByPerson(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
