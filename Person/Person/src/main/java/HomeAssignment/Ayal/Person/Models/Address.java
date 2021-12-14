package HomeAssignment.Ayal.Person.Models;

import HomeAssignment.Ayal.Person.Validation.EnumNamePattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Document(collection = "Address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotNull
    @EnumNamePattern(regexp = "ISRAEL", message = "State can be only ISRAEL")
    State state;
    @NotEmpty
    @Size(min = 3, max = 20, message = "city name length between 3-20 characters")
    String city;
    @NotEmpty
    @Size(min = 3, max = 50, message = "street name length between 3-50 characters")
    String street;
    @NotEmpty
    @Pattern(regexp = "^[0-9]*$", message = "zipcode should include only digits")
    String zipcode;
    @NotNull (message = "contains animals should be true/false")
    Boolean containsAnimals;
}
