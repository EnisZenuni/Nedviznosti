package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.User;

import java.util.Optional;

public interface UserDatabasePort {

    Optional<User> find(User user);

    User findUserById(Long userId);

    User signUp(User user);

    User signIn(User user);

    void delete(Long id);
}
