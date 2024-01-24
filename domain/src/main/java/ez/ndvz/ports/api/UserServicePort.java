package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.User;

import java.util.Optional;

public interface UserServicePort {

    User find(User user);
    Optional<User> findUserById(Long userId);

    Optional<User> findApplicationUserByName(String username);

    Optional<User> findApplicationUserByEmail(String email);

    void delete(Long id);

}
