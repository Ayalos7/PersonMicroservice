package HomeAssignment.Ayal.Person.Repositories;

import HomeAssignment.Ayal.Person.Models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person,String> {
}
