package iit.uni.RedisExample;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {
    private String id;

    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;

    Person toPerson() {
        return Person.builder()
                .id(id)
                .firstname(firstname)
                .lastname(lastname)
                .build();
    }

    PersonDto(Person person) {
        this.id = person.getId();
        this.firstname = person.getFirstname();
        this.lastname = person.getLastname();
    }
}