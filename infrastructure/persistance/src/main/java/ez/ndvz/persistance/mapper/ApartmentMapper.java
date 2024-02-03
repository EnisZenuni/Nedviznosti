package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.persistance.entity.ApartmentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ApartmentMapper {
    Apartment toDomain(ApartmentEntity apartmentEntity);
    ApartmentEntity toEntity(Apartment apartment);
}
