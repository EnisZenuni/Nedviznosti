package ez.ndvz.core.domain.models;


import ez.ndvz.core.domain.enumeration.Details;
import ez.ndvz.core.domain.enumeration.EnergySource;
import ez.ndvz.core.domain.enumeration.FlooringType;
import ez.ndvz.core.domain.enumeration.Heating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Setter
@Getter
public abstract class Property {
    @NonNull
    @NotBlank
    private String address; //TODO -> Create Value Object

    @NotNull
    @NotBlank(message = "Please provide a detailed description")
    private String description;

    @NotNull
    @NotBlank(message = "Please Insert size in km")
    @Positive
    private Float squareFootage;

    @NotNull
    @NotBlank(message = "Please insert number of bedrooms")
    @Size(min = 1)
    private Integer bedrooms;

    @NotNull
    @NotBlank(message = "Please insert number of bedrooms")
    @Size(min = 1)
    private Integer bathrooms;

    @NotNull
    @NotBlank(message = "Please select heating type from the provided options")
    private Heating heatingType;

    @NonNull
    @NotBlank
    private EnergySource energySource;

    @NonNull
    @NotBlank
    FlooringType flooringType;

    @NonNull
    List<Details> detailsList;
}
