package ez.ndvz.authentication.adapters;

import ez.ndvz.authentication.service.AgencyDetailsServiceImpl;
import ez.ndvz.authentication.service.JwtService;
import ez.ndvz.core.domain.enumeration.Roles;
import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.ports.spi.AgencyAuthenticationPort;
import ez.ndvz.ports.spi.AgencyDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AgencyAuthenticationService implements AgencyAuthenticationPort {
    private final AgencyDatabasePort agencyDatabasePort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AgencyDetailsServiceImpl agencyDetailsService;

    @Override
    public Agency signUp(Agency agency) {
        var registerAgency = Agency.builder()
                .name(agency.getName())
                .email(agency.getEmail())
                .contactNumber(agency.getContactNumber())
                .location(agency.getLocation())
                .establishmentDate(agency.getEstablishmentDate())
                .roles(Collections.singleton(Roles.AGENCY))
                .password(passwordEncoder.encode(agency.getPassword()))
                .isTrusted(agency.getIsTrusted())
                .propertyListings(agency.getPropertyListings())
                .agents(agency.getAgents())
                .build();

        agencyDatabasePort.create(registerAgency);

        return agency;
    }

    @Override
    public Agency signIn(Agency agency) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(agency.getEmail(), agency.getPassword()));

        return agencyDatabasePort.findAgencyByEmail(agency.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
    }

    @Override
    public String getToken(Agency agency) {
        var Agency = agencyDatabasePort.findAgencyByEmail(agency.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        return jwtService.generateToken(agencyDetailsService.loadUserByUsername(Agency.getEmail()));
    }
}
