package ez.ndvz.persistance.entity;

import ez.ndvz.persistance.enumerations.Details;
import ez.ndvz.persistance.enumerations.EnergySource;
import ez.ndvz.persistance.enumerations.FlooringType;
import ez.ndvz.persistance.enumerations.Heating;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Year;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("House")
public class HouseEntity extends PropertyEntity {
    @Builder
    public HouseEntity(@NonNull @NotBlank String address, @NotNull @NotBlank(message = "Please provide a detailed description") String description, Year yearBuilt, @NotNull @NotBlank(message = "Please insert number of floor or floor number") @Min(0) Integer numberOfFloors, @NotNull @NotBlank(message = "Please Insert size in km") Float squareFootage, @NotBlank(message = "Please insert number of bedrooms") @Size(min = 1) Integer bedrooms, @NotBlank(message = "Please insert number of bedrooms") @Size(min = 1) Integer bathrooms, @NotBlank(message = "Please select heating type from the provided options") Heating heatingType, @NotEmpty @NotBlank(message = "Please select energy source from the provided options") EnergySource energySource, @NotBlank(message = "Please select flooring type from the provided options") FlooringType flooringType, List<Details> detailsList, AgencyEntity agency, List<PropertyImageEntity> images, @Positive double price, @Positive double rentalPrice) {
        super(address, description, yearBuilt, numberOfFloors, squareFootage, bedrooms, bathrooms, heatingType, energySource, flooringType, detailsList, agency, images, price, rentalPrice);
    }
}