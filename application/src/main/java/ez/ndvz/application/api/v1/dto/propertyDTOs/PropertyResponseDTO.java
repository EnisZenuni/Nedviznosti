package ez.ndvz.application.api.v1.dto.propertyDTOs;

import ez.ndvz.core.domain.enumeration.PropertyType;
import ez.ndvz.core.domain.models.Image;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PropertyResponseDTO {
    String address; //TODO -> Create Value Object
    String description;
    Float squareFootage;
    Integer bedrooms;
    List<Image> imageList;
    Double price;
    PropertyType propertyType;
}
