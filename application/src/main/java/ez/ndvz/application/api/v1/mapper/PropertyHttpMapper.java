package ez.ndvz.application.api.v1.mapper;

import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyRequestDTO;
import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyResponseDTO;
import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyUpdateDTO;
import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;
import ez.ndvz.core.domain.models.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.Year;

@Mapper(componentModel = "spring")
public interface PropertyHttpMapper {

    ApartmentHttpMapper APARTMENT_HTTP_MAPPER = Mappers.getMapper(ApartmentHttpMapper.class);
    HouseHttpMapper HOUSE_HTTP_MAPPER = Mappers.getMapper(HouseHttpMapper.class);

    default Property toDomain(PropertyRequestDTO source) {
        if (source.getPropertyType().toString().equals("APARTMENT")) {
            return APARTMENT_HTTP_MAPPER.toDomain(source);
        } else if (source.getPropertyType().toString().equals("HOUSE")) {
            return HOUSE_HTTP_MAPPER.toDomain(source);
        }
        throw new IllegalArgumentException("Unsupported property entity type: " + source.getClass());
    }

    default PropertyResponseDTO toDTO(Property source) {
        if (source instanceof Apartment) {
            return APARTMENT_HTTP_MAPPER.toDTO((Apartment)source);
        } else if (source instanceof House) {
            return HOUSE_HTTP_MAPPER.toDTO((House) source);
        }
        throw new IllegalArgumentException("Unsupported property entity type: " + source.getClass());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "imageList", ignore = true)
    @Mapping(target = "yearBuilt", source = "yearBuilt", qualifiedByName = "mapIntegerToYear")
    @Mapping(target = "propertyType", ignore = true)
    Property update(PropertyUpdateDTO source, @MappingTarget Property target);

    @Named("mapIntegerToYear")
    default Year mapIntegerToYear(Integer year) {
        return (year != null) ? Year.of(year) : null;
    }
}
