package ez.ndvz.application.api.v1.dto.propertyDTOs;

import ez.ndvz.core.domain.enumeration.*;
import ez.ndvz.core.domain.models.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class PropertyRequestDTO {
    PropertyType propertyType;
    String address;
    String description;
    Float squareFootage;
    Integer bedrooms;
    Integer yearBuilt;
    Integer bathrooms;
    Heating heatingType;
    EnergySource energySource;
    FlooringType flooringType;
    List<Details> detailsList;
    List<Image> imageList;
    Double price;
    Double rentalPrice;
    Integer floor;
}
