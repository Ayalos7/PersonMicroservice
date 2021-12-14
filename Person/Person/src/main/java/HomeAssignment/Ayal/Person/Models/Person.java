package HomeAssignment.Ayal.Person.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.Valid;
import javax.validation.constraints.*;

@Document(collection = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @NotEmpty
    @Size(min = 3, max = 40, message = "id between 3-40 characters")
    String id;
    @NotEmpty
    @Size(min = 3, max = 20, message = "name between 3-20 characters")
    String name;
    @NotNull(message = "age between 0-200")
    @Min(0)
    @Max(200)
    int age;
    @NotNull (message = "Gender can't be null")
    Gender gender;
    @NotNull (message = "height bigger than 0")
    @Min(0)
    double height;
    @Min(0)
    double weight;
    @NotNull (message = "Address can't be null")
    @Valid
    Address address;
}