package ez.ndvz.core.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class House extends Property {

    private Long houseId;

    @NonNull
    @NotBlank
    private Integer numberOfFloors;

    @Positive
    private double price;

    @Positive
    private double rentalPrice;
}
