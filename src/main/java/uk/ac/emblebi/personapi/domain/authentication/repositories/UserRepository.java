package uk.ac.emblebi.personapi.domain.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.emblebi.personapi.domain.authentication.models.User;

import java.util.List;
import java.util.Optional;

/**
 * TODO: write you class description here
 *
 * @author
 */

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
