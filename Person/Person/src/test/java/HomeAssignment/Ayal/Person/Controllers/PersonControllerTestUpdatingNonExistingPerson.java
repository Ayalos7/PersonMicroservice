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

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTestUpdatingNonExistingPerson {
    Address addressUpdated = new Address(State.ISRAEL, "Tel-Aviv", "Street", "123123", false);
    Person personUpdated = new Person("0000000", "Test It", 66, Gender.FEMALE, 1.6, 73.5, addressUpdated);

    @LocalServerPort
    private int port;

    @Mock
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testControllerUpdateValidNonExistingPerson() throws Exception {
        //Updating person with valid fields, But the id doesn't exist on db
        ResponseEntity<?> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/Person/Update").toString(), personUpdated, String.class);
        assertEquals("Entered Id doesn't exist - can't update a non existing person", response.getBody());
    }
}