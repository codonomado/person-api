package uk.ac.emblebi.personapi.domain.person.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Data
public class PersonRequest {
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotBlank
    @Size(max = 3)
    private String age;

    @NotBlank
    @Size(max = 100)
    private String favouriteColour;

    @NotNull
    private List<String> hobbies;
}
