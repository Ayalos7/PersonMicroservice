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
public class PersonControllerTest {
    Address address1 = new Address(State.ISRAEL, "Tel-Aviv", "Street", "123123" , true);
    Person person1 = new Person("123141", "Test It", 66, Gender.FEMALE, 1.6, 73.5, address1);

    Address address2 = new Address(State.ISRAEL, "Tel-Aviv", "Street", "4321", false);
    Person person2 = new Person("987654321", "Person2", 19, Gender.FEMALE, 1.75, 65, address2);

    Address address2Updated = new Address(State.ISRAEL, "Tel-Aviv", "Moshe Dayan", "5555", true);
    Person person2Updated = new Person("987654321", "Person2", 20, Gender.FEMALE, 1.76, 70, address2Updated);

    @LocalServerPort
    private int port;

    @Mock
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testControllerAddAndUpdatePerson() throws Exception {
        ResponseEntity<?> response1 = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/Person/Add").toString(), person1, String.class);
        assertEquals("Person added", response1.getBody());
        ResponseEntity<?> response2 = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/Person/Add").toString(), person2, String.class);


        ResponseEntity<?> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/Person/Update").toString(), person2Updated, String.class);
        assertEquals("Person updated", response.getBody());
    }




}