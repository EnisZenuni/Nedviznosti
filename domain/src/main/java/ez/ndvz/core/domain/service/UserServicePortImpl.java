package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.User;
import ez.ndvz.ports.api.UserServicePort;
import org.springframework.stereotype.Service;

@Service
public class UserServicePortImpl implements UserServicePort {
    @Override
    public User find(User user) {
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        return null;
    }

    @Override
    public User signUp(User user) {
        return null;
    }

    @Override
    public User signIn(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
