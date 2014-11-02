package scratch.user;

import org.springframework.data.repository.CrudRepository;

/**
 * This is a Spring Data {@link User} repository that is used to test that the {@code User} can actually be persisted
 * with an ORM.
 *
 * @author Karl Bennett
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
