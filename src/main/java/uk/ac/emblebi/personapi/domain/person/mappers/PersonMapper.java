package uk.ac.emblebi.personapi.domain.person.mappers;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import uk.ac.emblebi.personapi.domain.person.models.Person;
import uk.ac.emblebi.personapi.domain.person.requests.PersonRequest;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Component
public class PersonMapper {
    public Person personRequestToPerson(PersonRequest personRequest) {
        Person person = new Person();

        if (!StringUtils.isEmpty(personRequest.getFirstName())) {
            person.setFirstName(personRequest.getFirstName());
        }

        if (!StringUtils.isEmpty(personRequest.getLastName())) {
            person.setFirstName(personRequest.getLastName());
        }

        if (!StringUtils.isEmpty(personRequest.getAge())) {
            person.setFirstName(personRequest.getAge());
        }

        if (!StringUtils.isEmpty(personRequest.getFavouriteColour())) {
            person.setFirstName(personRequest.getFavouriteColour());
        }

        if (!CollectionUtils.isEmpty(personRequest.getHobbies())) {
            person.setHobbies(personRequest.getHobbies());
        }

        return person;
    }
}
