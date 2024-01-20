package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.User;

public interface UserServicePort {

    User find(User user);
    User findUserById(Long userId);

    User signUp(User user);

    User signIn(User user);

    void delete(Long id);

}
