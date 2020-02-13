package uk.ac.emblebi.personapi.domain.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.emblebi.personapi.domain.authentication.models.Role;
import uk.ac.emblebi.personapi.domain.authentication.models.RoleName;

import java.util.Optional;

/**
 * TODO: write you class description here
 *
 * @author
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}