package ez.ndvz.authentication.adapters;

import ez.ndvz.authentication.service.JwtService;
import ez.ndvz.authentication.service.UserDetailsServiceImpl;
import ez.ndvz.core.domain.enumeration.Roles;
import ez.ndvz.core.domain.models.User;
import ez.ndvz.ports.spi.AuthenticationServicePort;
import ez.ndvz.ports.spi.UserDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationServicePort {

    private final UserDatabasePort userDatabasePort;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;




    //TODO not return a whole user
    @Override
    public User signUp(User user) {
        var User = ez.ndvz.core.domain.models.User.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .phoneNumber(user.getPhoneNumber())
                .roles(Collections.singleton(Roles.USER))
                .build();

        userDatabasePort.create(User);

        return user;
    }

    @Override
    public User signIn(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        var User = userDatabasePort.findApplicationUserByEmail(user.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        return User;
    }

    @Override
    public String getToken(User user) {
        var User = userDatabasePort.findApplicationUserByEmail(user.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        return  jwtService.generateToken(userDetailsService.loadUserByUsername(User.getEmail()));
    }
}
