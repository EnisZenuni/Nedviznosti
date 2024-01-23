package ez.ndvz.persistance.adapter;

import ez.ndvz.core.domain.models.User;
import ez.ndvz.core.exceptions.ResourceNotFoundException;
import ez.ndvz.persistance.mapper.UserMapper;
import ez.ndvz.persistance.repository.UserRepository;
import ez.ndvz.ports.spi.UserDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.text.MessageFormat;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDatabaseAdapter implements UserDatabasePort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public User exist(Long id) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format("User with code {0} not found", id)));
        return userMapper.toDomain(userEntity);
    }

    @Override
    public User find(User user) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User>findUserById(Long userId) {
        return Optional.of(exist(userId));
    }

    @Override
    public Optional<User> findApplicationUserByName(String username) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<User> findApplicationUserByEmail(String email) {
        var user = userRepository.findApplicationUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));


        return Optional.of(userMapper.toDomain(user));
    }


    @Override
    public void delete(Long id) {
        var agencyOptional = userRepository.findById(id);
        agencyOptional.ifPresent(userRepository::delete);
    }
}
