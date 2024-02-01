package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface UserDatabasePort {
    User exist(Long id);

    User find(User user);

    Optional<User>findUserById(Long userId);

    Optional<User> findApplicationUserByName(String username);

    Optional<User> findApplicationUserByEmail(String email);

    void delete(Long id);
}
