package scratch.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

import static java.lang.String.*;

/**
 * An implementation of the {@link Users} interface that uses a spring data repository.
 *
 * @author Karl Bennett
 */
@Component
public class RepositoryUsers implements Users {

    private final UserRepository repository;

    @Autowired
    public RepositoryUsers(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {

        // Null out the ID's so that a create is actually attempted not an update.
        user.setId(null);
        user.getAddress().setId(null);

        return repository.save(user);
    }

    @Override
    public User retrieve(Long id) {

        return repository.findOne(id);
    }

    @Override
    public Iterable<User> retrieve() {

        return repository.findAll();
    }

    @Override
    public User update(User user) {

        if (null == user.getId()){
            throw new EntityNotFoundException(format("User %s has not been persisted.", user));
        }

        return repository.save(user);
    }

    @Override
    public void delete(Long id) {

        repository.delete(id);
    }

    @Override
    public void deleteAll() {

        repository.deleteAll();
    }
}
