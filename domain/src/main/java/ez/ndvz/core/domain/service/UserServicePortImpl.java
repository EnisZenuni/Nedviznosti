package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.User;
import ez.ndvz.ports.api.UserServicePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<User> findApplicationUserByName(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findApplicationUserByEmail(String email) {
        return Optional.empty();
    }


    @Override
    public void delete(Long id) {

    }
}
