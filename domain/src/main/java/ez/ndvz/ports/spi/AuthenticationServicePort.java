package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.User;

public interface AuthenticationServicePort {
     User signUp(User user);
     User signIn(User user);
     String getToken(User user);
}
