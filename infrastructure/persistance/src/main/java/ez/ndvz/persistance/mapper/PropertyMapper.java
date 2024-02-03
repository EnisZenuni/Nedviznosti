package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;
import ez.ndvz.core.domain.models.Property;
import ez.ndvz.persistance.entity.ApartmentEntity;
import ez.ndvz.persistance.entity.HouseEntity;
import ez.ndvz.persistance.entity.PropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PropertyMapper {
    //Property toDomain(PropertyEntity source);

    ApartmentMapper APARTMENT_MAPPER = Mappers.getMapper(ApartmentMapper.class);
    HouseMapper HOUSE_MAPPER = Mappers.getMapper(HouseMapper.class);

    default Property toDomain(PropertyEntity source) {
        if (source instanceof ApartmentEntity) {
            return APARTMENT_MAPPER.toDomain((ApartmentEntity) source);
        } else if (source instanceof HouseEntity) {
            return HOUSE_MAPPER.toDomain((HouseEntity) source);
        }
        throw new IllegalArgumentException("Unsupported property entity type: " + source.getClass());
    }

    default PropertyEntity toEntity(Property source) {
        if (source instanceof Apartment) {
            return APARTMENT_MAPPER.toEntity((Apartment) source);
        } else if (source instanceof House) {
            return HOUSE_MAPPER.toEntity((House) source);
        }
        throw new IllegalArgumentException("Unsupported property entity type: " + source.getClass());
    }
}
