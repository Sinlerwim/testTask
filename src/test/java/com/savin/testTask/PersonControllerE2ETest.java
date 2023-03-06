package com.savin.testTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.savin.testTask.dto.PersonDTO;
import com.savin.testTask.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql({"/data.sql"})
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class PersonControllerE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void personControllerTest() throws Exception {

        Person person = new Person();
        person.setId("e561ede7-0e0c-4673-b84c-47d1ac5fed69");
        person.setFirstName("John");
        person.setLastName("Smith");
        person.setDateOfBirth(LocalDate.of(2000, 5, 23));

        MvcResult mvcResult = mockMvc.perform(get("/users/e561ede7-0e0c-4673-b84c-47d1ac5fed69")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        PersonDTO personDTO = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), PersonDTO.class);
        assertThat(personDTO.getId()).isEqualTo(person.getId());
        assertThat(personDTO.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(personDTO.getLastName()).isEqualTo(person.getLastName());
        assertThat(personDTO.getAge()).isEqualTo(22);
    }
}
