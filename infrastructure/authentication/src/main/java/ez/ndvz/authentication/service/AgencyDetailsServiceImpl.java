package ez.ndvz.authentication.service;

import ez.ndvz.ports.spi.AgencyDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgencyDetailsServiceImpl implements UserDetailsService {
    private final AgencyDatabasePort agencyDatabasePort;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return agencyDatabasePort.findAgencyByEmail(email)
                .map(AgencyDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("Agency %s not found" + email));
    }
}
