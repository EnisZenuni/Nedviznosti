package ez.ndvz.application.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
public class SignInRequestDTO {
    String email;
    String password;
}

