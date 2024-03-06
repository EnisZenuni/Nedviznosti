package ez.ndvz.core.domain.models;


import ez.ndvz.core.domain.enumeration.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Year;
import java.util.List;

@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
public abstract class Property {

    private String id;

    private String address; //TODO -> Create Value Object

    private String description;

    private Float squareFootage;

    private Integer bedrooms;

    private Year yearBuilt;

    private Integer bathrooms;

    private Heating heatingType;

    private Integer numberOfFloors;

    private EnergySource energySource;

    FlooringType flooringType;

    List<Details> detailsList;

    List<Image> imageList;

    private Double price;

    private Double rentalPrice;

    private PropertyType propertyType;
}
