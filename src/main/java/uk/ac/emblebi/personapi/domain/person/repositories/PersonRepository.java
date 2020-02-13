package uk.ac.emblebi.personapi.domain.person.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.emblebi.personapi.domain.person.models.Person;

/**
 * TODO: write you class description here
 *
 * @author
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
}
