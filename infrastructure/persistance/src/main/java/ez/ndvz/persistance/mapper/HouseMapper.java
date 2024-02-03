package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.House;
import ez.ndvz.persistance.entity.HouseEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface HouseMapper {
    House toDomain(HouseEntity houseEntity);
    HouseEntity toEntity(House house);
}
