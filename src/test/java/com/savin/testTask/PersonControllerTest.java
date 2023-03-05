package com.savin.testTask.controller;

import com.savin.testTask.dto.PersonDTO;
import com.savin.testTask.mapper.PersonMapper;
import com.savin.testTask.model.Person;
import com.savin.testTask.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonControllerTest {

    private PersonController personController;

    @Mock
    private PersonService personService;

    @Mock
    private PersonMapper personMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personController = new PersonController(personMapper, personService);
    }

    @Test
    void testMain() {
        String id = "123";
        Person person = new Person();
        person.setId(id);
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(id);
        when(personService.getPersonById(anyString())).thenReturn(person);
        when(personMapper.toDTO(person)).thenReturn(personDTO);

        ResponseEntity<PersonDTO> responseEntity = personController.main(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(personDTO, responseEntity.getBody());
    }
}
