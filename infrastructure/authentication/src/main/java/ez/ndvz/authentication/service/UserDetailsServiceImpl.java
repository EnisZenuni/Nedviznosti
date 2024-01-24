package ez.ndvz.authentication.service;

import ez.ndvz.ports.spi.UserDatabasePort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//TODO figure out why dependency injection isn't working here

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  UserDatabasePort userDatabasePort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDatabasePort.findApplicationUserByEmail(email)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found" + email));

    }
}
