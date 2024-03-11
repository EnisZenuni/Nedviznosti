package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Agency;

public interface AgencyAuthenticationPort {
    Agency signUp(Agency agency);
    Agency signIn(Agency agency);
    String getToken(Agency agency);
}
