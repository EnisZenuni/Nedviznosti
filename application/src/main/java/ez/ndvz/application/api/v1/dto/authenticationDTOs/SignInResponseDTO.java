package ez.ndvz.application.api.v1.dto.authenticationDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class SignInResponseDTO {
    String name;
    String lastName;
    String email;
    String token;
    String tokenType = "Bearer"; //TODO maybe remove
}
