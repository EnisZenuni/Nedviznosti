package ez.ndvz.persistance.enumerations;

import ez.ndvz.core.domain.models.House;
import ez.ndvz.persistance.entity.HouseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface HouseMapper {
    House toDomain(HouseEntity houseEntity);
    HouseEntity toEntity(House house);
}
