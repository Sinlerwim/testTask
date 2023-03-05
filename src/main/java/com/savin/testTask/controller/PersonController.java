package com.savin.testTask.controller;

import com.savin.testTask.dto.PersonDTO;
import com.savin.testTask.mapper.PersonMapper;
import com.savin.testTask.model.Person;
import com.savin.testTask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonMapper personMapper;

    private final PersonService personService;

    @Autowired
    public PersonController(PersonMapper personMapper, PersonService personService) {
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity main(@PathVariable String id) {
        Person person = personService.getPersonById(id);
        PersonDTO personDTO = personMapper.toDTO(person);
        return new ResponseEntity<>(personDTO,
                HttpStatus.OK
        );
    }

}
