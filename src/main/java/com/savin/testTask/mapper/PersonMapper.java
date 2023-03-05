package com.savin.testTask.mapper;

import com.savin.testTask.dto.PersonDTO;
import com.savin.testTask.model.Person;
import com.savin.testTask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    private PersonService personService;

    @Autowired
    public PersonMapper(PersonService personService) {
        this.personService = personService;
    }

    public PersonDTO toDTO(Person person) {
        final PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setAge(personService.getAgeByPerson(person));
        return personDTO;
    }
}
