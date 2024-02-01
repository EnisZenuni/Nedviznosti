package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.User;
import ez.ndvz.ports.api.UserServicePort;
import ez.ndvz.ports.spi.UserDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServicePortImpl implements UserServicePort {

    private final UserDatabasePort userDatabasePort;

    @Override
    public User find(User user) {
        return null;
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userDatabasePort.findUserById(userId);
    }

    @Override
    public Optional<User> findApplicationUserByName(String username) {
        return userDatabasePort.findApplicationUserByName(username);
    }

    @Override
    public Optional<User> findApplicationUserByEmail(String email)
    {
        return userDatabasePort.findApplicationUserByEmail(email);
    }


    @Override
    public void delete(Long id) {
        userDatabasePort.delete(id);
    }
}
