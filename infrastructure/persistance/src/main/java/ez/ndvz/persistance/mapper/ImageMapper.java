package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Image;
import ez.ndvz.persistance.entity.PropertyImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ImageMapper {
    @Mapping(target = "property",ignore = true)
    Image toDomain(PropertyImageEntity imageEntity);
    @Mapping(target = "property",ignore = true)
    PropertyImageEntity toEntity(Image image);

    List<Image> toDomain(List<PropertyImageEntity> propertyImageEntities);
    List<PropertyImageEntity> toEntity(List<Image> images);
}
