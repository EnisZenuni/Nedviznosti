package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;
import ez.ndvz.persistance.entity.AgencyEntity;
import ez.ndvz.persistance.entity.PropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface AgencyMapper {

    PropertyMapper PROPERTY_MAPPER = Mappers.getMapper(PropertyMapper.class);

    @Mapping(target = "propertyListings", source = "propertyListings", qualifiedByName = "toDomainList")
    Agency toDomain(AgencyEntity agencyEntity);

    @Mapping(target = "propertyListings", source = "propertyListings", qualifiedByName = "toEntityList")
    AgencyEntity toEntity(Agency agency);

    @Named("toDomainList")
    default List<Property> toDomainList(List<PropertyEntity> propertyListings) {
       return propertyListings.stream()
                .map(PROPERTY_MAPPER::toDomain)
                .collect(Collectors.toList());
    }

    @Named("toEntityList")
    default List<PropertyEntity> toEntityList(List<Property> propertyListings) {
        return propertyListings.stream()
                .map(PROPERTY_MAPPER::toEntity)
                .collect(Collectors.toList());
    }
}
