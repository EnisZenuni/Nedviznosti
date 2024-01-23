package ez.ndvz.core.domain.models;


import ez.ndvz.core.domain.enumeration.Details;
import ez.ndvz.core.domain.enumeration.EnergySource;
import ez.ndvz.core.domain.enumeration.FlooringType;
import ez.ndvz.core.domain.enumeration.Heating;
import lombok.*;

import java.time.Year;
import java.util.List;

@AllArgsConstructor
@Builder
@Setter
@Getter
public abstract class Property {

    private String id;

    private String address; //TODO -> Create Value Object

    private String description;

    private Float squareFootage;

    private Integer bedrooms;

    private Year yearBuilt;

    private Integer bathrooms;

    private Heating heatingType;


    private EnergySource energySource;

    FlooringType flooringType;

    List<Details> detailsList;

    List<Image> imageList;

    private double price;

    private double rentalPrice;
}
