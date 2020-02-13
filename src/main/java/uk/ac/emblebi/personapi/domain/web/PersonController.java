package uk.ac.emblebi.personapi.domain.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uk.ac.emblebi.personapi.domain.person.responses.PersonResponse;
import uk.ac.emblebi.personapi.domain.person.models.Person;
import uk.ac.emblebi.personapi.domain.person.services.PersonService;

import javax.validation.Valid;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author
 */

@RestController
@RequestMapping(value ="/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping("/")
    public ResponseEntity<List<PersonResponse>> index() {
        return ResponseEntity.ok(this.personService.getAll());
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PersonResponse> create(@Valid @RequestBody Person person) {
        return ResponseEntity.ok(this.personService.addPerson(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> show(@PathVariable(value = "id") Long personId) {
        return ResponseEntity.ok(this.personService.getPersonByPersonId(personId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PersonResponse> update(@PathVariable(value = "id") Long personId,
                           @Valid @RequestBody Person personDetails) {
        return ResponseEntity.ok(this.personService.updatePerson(personId, personDetails));

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long personId) {
        this.personService.deletePerson(personId);
        return ResponseEntity.ok().build();
    }
}


