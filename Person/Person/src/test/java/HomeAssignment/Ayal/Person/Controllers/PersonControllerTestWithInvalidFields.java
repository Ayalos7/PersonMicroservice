package HomeAssignment.Ayal.Person.Controllers;

import HomeAssignment.Ayal.Person.Models.Address;
import HomeAssignment.Ayal.Person.Models.Gender;
import HomeAssignment.Ayal.Person.Models.Person;
import HomeAssignment.Ayal.Person.Models.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTestWithInvalidFields {
    Address address = new Address(State.ISRAEL, "Tel-Aviv", "Street", "1234ABC", null);
    Person person = new Person("123456789", "Person1", 20, Gender.MALE, 1.65, 60, address);

    Address addressUpdated = new Address(State.USA, "Tel-Aviv", null, "1234", false);
    Person personUpdated = new Person("123456789", "Person1", 20, Gender.MALE, 1.65, 60, addressUpdated);

    @LocalServerPort
    private int port;

    @Mock
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testControllerAddInvalidPerson() throws Exception {
        //Adding Person with invalid fields: Zipcode, age, containsAnimals
        ResponseEntity<?> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/Person/Add").toString(), person, String.class);
                assertEquals("{\"address.containsAnimals\":\"contains animals should be true/false\","  +
                        "\"address.zipcode\":\"zipcode should include only digits\"}", response.getBody());
    }

    @Test
    public void testControllerUpdateInvalidPerson() throws Exception {
        //Updating person with invalid fields: State, street
        ResponseEntity<?> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/Person/Update").toString(), personUpdated, String.class);
        assertEquals("{\"address.state\":\"State can be only ISRAEL\"," +
                "\"address.street\":\"must not be empty\"}", response.getBody());
    }


}