package HomeAssignment.Ayal.Person.Advice;

import HomeAssignment.Ayal.Person.CustomExceptions.PersonDoesntExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class PersonDoesntExistControllerException {
    @ExceptionHandler( value= {PersonDoesntExistException.class})
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public String AdminApiResponseException(Exception exception){
        return exception.getMessage();
    }
}
