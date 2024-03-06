package ez.ndvz.application.api.v1.dto.propertyDTOs;

import ez.ndvz.core.domain.enumeration.Details;
import ez.ndvz.core.domain.enumeration.EnergySource;
import ez.ndvz.core.domain.enumeration.FlooringType;
import ez.ndvz.core.domain.enumeration.Heating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class PropertyUpdateDTO {
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
    //TODO -> Create an EDIT function for Images do not handle it like this because we get hibernate "a collection was no longer references"
    //<Image> imageList;
    Double price;
    Double rentalPrice;
    Integer floor;
}
