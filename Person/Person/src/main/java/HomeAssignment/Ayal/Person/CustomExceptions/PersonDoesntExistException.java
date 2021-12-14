package HomeAssignment.Ayal.Person.CustomExceptions;

public class PersonDoesntExistException extends Exception {

    public PersonDoesntExistException() {

    }

    public PersonDoesntExistException(String message) {
        super(message);
    }
}
