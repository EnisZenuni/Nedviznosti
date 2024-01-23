package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.persistance.entity.ApartmentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ApartmentMapper {
    Apartment toDomain(ApartmentEntity apartmentEntity);
    ApartmentEntity toEntity(Apartment apartment);
}
