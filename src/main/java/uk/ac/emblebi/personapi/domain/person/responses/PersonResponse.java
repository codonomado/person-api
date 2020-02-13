package uk.ac.emblebi.personapi.domain.person.responses;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"created_at", "updated_at"})
public class PersonResponse {
    private String firstName;
    private String lastName;
    private String age;
    private String favouriteColour;
    private List<String> hobbies;
}
