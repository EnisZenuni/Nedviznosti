package ez.ndvz.application.api.v1.mapper;

import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignUpRequestDTO;
import ez.ndvz.core.domain.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserHttpMapper {
    User toDomain(SignUpRequestDTO signUpRequestDTO);

}
