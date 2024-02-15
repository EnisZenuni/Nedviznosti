package ez.ndvz.application.api.v1.dto.authenticationDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SignInResponseDTO {
    String name;
    String lastName;
    String email;
    String token;
    String tokenType = "Bearer"; //TODO maybe remove
}
