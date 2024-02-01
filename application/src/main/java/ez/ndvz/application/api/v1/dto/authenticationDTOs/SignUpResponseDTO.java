package ez.ndvz.application.api.v1.dto.authenticationDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class SignUpResponseDTO {
    String jwt;
    boolean success;
    String message;
}
