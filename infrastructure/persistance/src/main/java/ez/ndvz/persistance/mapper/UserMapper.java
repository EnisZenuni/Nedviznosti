package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.User;
import ez.ndvz.persistance.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);
}
