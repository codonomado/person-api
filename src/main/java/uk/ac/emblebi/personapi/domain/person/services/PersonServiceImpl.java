package uk.ac.emblebi.personapi.domain.person.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.emblebi.personapi.domain.common.exceptions.ResourceNotFoundException;
import uk.ac.emblebi.personapi.domain.person.models.Person;
import uk.ac.emblebi.personapi.domain.person.repositories.PersonRepository;
import uk.ac.emblebi.personapi.domain.person.responses.PersonResponse;


import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Log4j2
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonResponse> getAll() {
        return this.personRepository
            .findAll()
            .stream()
            .map(this::createPersonResponseFromPerson)
            .collect(Collectors.toList());
    }


    @Override
    public PersonResponse getPersonByPersonId(Long personId) {
        Person person = this.personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));
        return createPersonResponseFromPerson(person);
    }

    @Override
    public PersonResponse addPerson(Person person) {
        this.personRepository.save(person);
        return createPersonResponseFromPerson(person);
    }

    @Override
    public PersonResponse updatePerson(Long personId, Person personDetails) {
        Person person = this.personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));

        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setAge(personDetails.getAge());
        person.setFavouriteColour(personDetails.getFavouriteColour());

        personDetails.getHobbies().forEach(hobby -> person.getHobbies().add(hobby));

        this.personRepository.save(person);
        return createPersonResponseFromPerson(person);
    }

    @Override
    public void deletePerson(Long personId) {
        Person person = this.personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));
        this.personRepository.delete(person);
    }

    private PersonResponse createPersonResponseFromPerson(Person person) {
        PersonResponse personResponse = new PersonResponse();

        personResponse.setFirstName(person.getFirstName());
        personResponse.setLastName(person.getLastName());
        personResponse.setAge(person.getAge());
        personResponse.setFavouriteColour(person.getFavouriteColour());
        personResponse.setHobbies(person.getHobbies());

        return personResponse;
    }
}
