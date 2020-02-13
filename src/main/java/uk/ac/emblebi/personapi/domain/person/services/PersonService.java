package uk.ac.emblebi.personapi.domain.person.services;

import uk.ac.emblebi.personapi.domain.person.responses.PersonResponse;
import uk.ac.emblebi.personapi.domain.person.models.Person;

import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author
 */

public interface PersonService {

    /**
     * Returns all the "Person" objects from an index action
     * @return list of "Persons" (success status: 200)
     */
    public List<PersonResponse> getAll();

    /**
     * Returns one "Person" based on the "personId" parameter provided
     * @param personId
     * @return single "Person" object (success status: 200)
     */
     public PersonResponse getPersonByPersonId(Long personId);


    /**
     * Creates a new "Person" object based on the params provided in the "PersonRequest" object
     * @param person
     * @return single "Person" object (success status: 201)
     */
     public PersonResponse addPerson(Person person);


    /**
     * Edits properties on an existing "Person" object.
     * @param personId
     * @return single "Person" object (success status: 200)
     */
    public PersonResponse updatePerson(Long personId, Person personDetails);


    /**
     * Deletes a "Person" object from the database
     * @param personId
     * @return single "Person" object (success status: 200)
     */
    public void deletePerson(Long personId);
}
