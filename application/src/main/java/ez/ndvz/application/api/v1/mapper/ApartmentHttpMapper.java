package ez.ndvz.application.api.v1.mapper;

import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyRequestDTO;
import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyResponseDTO;
import ez.ndvz.core.domain.models.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Year;

@Mapper(componentModel = "spring")
public interface ApartmentHttpMapper {

    PropertyResponseDTO toDTO(Apartment apartment);

    @Mapping(target = "yearBuilt", source = "yearBuilt", qualifiedByName = "mapIntegerToYear")
    Apartment toDomain(PropertyRequestDTO propertyRequestDTO);
    @Named("mapIntegerToYear")
    default Year mapIntegerToYear(Integer year) {
        return (year != null) ? Year.of(year) : null;
    }
}
