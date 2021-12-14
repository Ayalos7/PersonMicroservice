package HomeAssignment.Ayal.Person.Controllers;


import HomeAssignment.Ayal.Person.CustomExceptions.PersonDoesntExistException;
import HomeAssignment.Ayal.Person.Models.Person;
import HomeAssignment.Ayal.Person.Services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping("Person/Add")
    private ResponseEntity<?> addPerson(@Valid @RequestBody Person person) {
        personService.savePerson(person);
        return ResponseEntity.ok().body("Person added");
    }

    @GetMapping("Person/Get/{id}")
    private ResponseEntity<?> getPerson(@PathVariable String id) {

        return ResponseEntity.ok().body(personService.getPerson(id));
    }

    @PostMapping("Person/Update")
    private ResponseEntity<?> updatePerson(@Valid @RequestBody Person person) throws PersonDoesntExistException {
        personService.updatePerson(person);
        return ResponseEntity.ok().body("Person updated");
    }

    @GetMapping("Person/GetAll")
    private  ResponseEntity<?> getAllPersons() {

        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @DeleteMapping("Person/Delete/{id}")
    private ResponseEntity<?> deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().body("Person deleted");
    }

}