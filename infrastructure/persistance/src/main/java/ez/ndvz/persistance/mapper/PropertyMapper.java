package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Property;
import ez.ndvz.persistance.entity.PropertyEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PropertyMapper {
    Property toDomain(PropertyEntity propertyEntity);

    PropertyEntity toEntity(Property property);
}
