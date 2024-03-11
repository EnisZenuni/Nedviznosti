package ez.ndvz.authentication.service;

import ez.ndvz.core.domain.models.Agency;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Builder
public class AgencyDetailsImpl implements UserDetails {
    private final Agency agency;

    public AgencyDetailsImpl(Agency agency) {
        this.agency = agency;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return agency.getRoles().stream()
                .map(roles -> new SimpleGrantedAuthority("ROLE_" + roles.name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return agency.getPassword();
    }

    @Override
    public String getUsername() {
        return agency.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
