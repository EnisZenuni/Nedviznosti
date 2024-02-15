package ez.ndvz.application.api.v1.mapper;

import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignInRequestDTO;
import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignUpRequestDTO;
import ez.ndvz.core.domain.models.User;
import ez.ndvz.persistance.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserHttpMapper {
    User toDomain(SignUpRequestDTO signUpRequestDTO);

    User toDomain(SignInRequestDTO signInRequestDTO);

    UserEntity toEntity(SignInRequestDTO signInRequestDTO);

    UserEntity toEntity(SignUpRequestDTO signUpRequestDTO);
}
