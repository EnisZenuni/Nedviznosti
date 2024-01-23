package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.User;
import ez.ndvz.persistance.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);
}
