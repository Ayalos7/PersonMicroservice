package HomeAssignment.Ayal.Person.Services;

import HomeAssignment.Ayal.Person.CustomExceptions.PersonDoesntExistException;
import HomeAssignment.Ayal.Person.Models.Person;
import HomeAssignment.Ayal.Person.Repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(Person person) throws PersonDoesntExistException {
        if (!personRepository.existsById(person.getId())) {
            throw new PersonDoesntExistException("Entered Id doesn't exist - can't update a non existing person");
        }
        personRepository.save(person);
    }

    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }

    public Optional<Person> getPerson(String id) {
        return personRepository.findById(id);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
