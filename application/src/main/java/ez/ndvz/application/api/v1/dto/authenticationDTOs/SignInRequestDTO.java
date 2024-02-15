package ez.ndvz.application.api.v1.dto.authenticationDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class SignInRequestDTO {
    String email;
    String password;
}

