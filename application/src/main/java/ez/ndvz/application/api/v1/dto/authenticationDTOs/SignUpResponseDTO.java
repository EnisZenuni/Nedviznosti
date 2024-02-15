package ez.ndvz.application.api.v1.dto.authenticationDTOs;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class SignUpResponseDTO {
    String jwt;
    boolean success;
    String message;
}
